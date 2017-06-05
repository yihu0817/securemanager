package com.ittx.java1608.secure.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ittx.java1608.secure.model.User;

public class SignOnFilter implements Filter {
	private FilterConfig config;

	/**
	 * nonProtectedUris 存贮不需要权限处理的URL
	 */
	private HashMap nonProtectedUris = new HashMap();

	/**
	 * init方法在tomcat启动、程序加载时执行
	 */
	public void init(FilterConfig config) {
		this.config = config;
		String uri = config.getInitParameter("non-protected.uri");
		StringTokenizer tok = new StringTokenizer(uri, ",");

		while (tok.hasMoreTokens()) {
			String url = tok.nextToken();
			nonProtectedUris.put(url, url);
		}
	}

	/**
	 * doFilter 每次.jspa的URL请求时执行，与web.xml配置文件有关
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		int index = 0;
		if(uri.lastIndexOf("/") !=-1){
			index = uri.lastIndexOf("/");
			uri = uri.substring(index+1);
		}
		if (isNonProtected(uri) == false) // 如果配置文件属性non-protected.uri（不处理uri地址）中不包含请求uri,则执行下面判继
		{

			if(loginAuthred(req) == false){
				config.getServletContext().getRequestDispatcher("/erorr_nologin.jsp").forward(request, response);
				return;
			}
			if(getPermission(req) == false){
				config.getServletContext().getRequestDispatcher("/securieserror.jsp").forward(request, response);
				return;
			}
		}
		
		chain.doFilter(request, response);
	}

	public void destroy() {
		nonProtectedUris.clear();
	}

	/**
	 * 登录认证不成功 返回 false;
	 * 登录成功返回   true;
	 * @param req
	 * @return
	 */
	private boolean loginAuthred(HttpServletRequest req){
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 权限认证
	 * @param request
	 * @return
	 */
	private boolean getPermission(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session == null) {
			return false;
		}
		//登录成功将userId保存到session中
		User user = (User) session.getAttribute("user");
		String uri = request.getRequestURI();
		int lastSlashPos = uri.lastIndexOf("/");
		String action = uri.substring(lastSlashPos + 1);
		try {
			return UserManager.getInstance().getGroupPermission(user, action);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 判断当前请求是否需要登录认证
	 * true: 不需要登录认证
	 * false: 需要登录认证
	 * @param uri
	 * @return
	 */
	private boolean isNonProtected(String uri) {
		return (nonProtectedUris.get(uri) != null);
	}

}