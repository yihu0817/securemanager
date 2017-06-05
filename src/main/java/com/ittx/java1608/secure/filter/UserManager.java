package com.ittx.java1608.secure.filter;

import java.util.Set;

import com.ittx.java1608.secure.model.Function;
import com.ittx.java1608.secure.model.Role;
import com.ittx.java1608.secure.model.User;


public class UserManager  {
//	@Autowired
//	private UserDao userDao;
	
	private static UserManager UMG = null;
	public static UserManager getInstance(){
		if(UMG==null){
			UMG = new UserManager();
			initUserManager();
		}
		return UMG;
	}
	
	public  boolean getGroupPermission(User user, String action) {
		boolean results = false;
		Role role = user.getRole();
		
		Set<Function> functionLists = role.getFunctionLists();
		for(Function fuction : functionLists){
			if(fuction.getFunctionCode().equals(action)){
				results = true;
				break;
			}
		}

		return results;
	}
	public static void initUserManager(){
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-hibernate.xml");
//		userDao = (UserDao) ctx.getBean("userDao");
		
//		userDao = (UserDao) WebApplication.getBean("userDao");
//		userDao = WebApplication.getBean(UserDao.class);
	}

}
