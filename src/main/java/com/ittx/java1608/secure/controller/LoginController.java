package com.ittx.java1608.secure.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ittx.java1608.secure.model.Role;
import com.ittx.java1608.secure.model.User;
import com.ittx.java1608.secure.service.SecureService;
import com.ittx.java1608.secure.service.UserService;
import com.ittx.java1608.secure.utils.Configes;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecureService secureService;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("user", null);
		session.invalidate();
		return "login";
	}
	

	// @RequestMapping(value="/login_submit",method=RequestMethod.GET)
	@PostMapping("/login_submit")
	public String loginSubmit(HttpServletRequest req,String name, String password, Model model) {
		User user = userService.checkUser(name, password);
		if (user != null) {
			if (user.getState() == Configes.CHECK_STATE_NO) {
				model.addAttribute("message", "正在审核中!");
				return "login";
			} else {
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				return "main";
			}
		} else {
			model.addAttribute("message", "用户名或密码不存在!");
			return "login";
		}

	}

	@GetMapping("/register")
	public String regesiter() {
		return "user/register";
	}

	@PostMapping("/register_submit")
	public String regesiterSubmit(User user, Model model) {
		userService.addUser(user);
		model.addAttribute("message", "注册成功，等待审核！");
		return "user/register";
	}
	
	@RequestMapping("/listuser")
	public String useList(Model model) {
		List<User> userlists = userService.getUserAll();
		model.addAttribute("userLists", userlists);
		return "user/listuser";
	}
	
	@GetMapping("/checkuser")
	public String checkUser(int userid,Model model){
		User user = userService.getUserById(userid);
		model.addAttribute("user", user);
		
		List<Role>  roleList = secureService.getAllRoles();
		model.addAttribute("roleList", roleList);
		
		return "user/checkuser";
	}
	
	@PostMapping("/usercheck_submit")
	public String checkUserSubmit(int userid,int state,int roleId){
		User user = userService.getUserById(userid);
		user.setState(state);
		user.setRole(secureService.getRoleById(roleId));
		
		userService.checkUser(user);
		
		return "redirect:listuser";
	}

}
