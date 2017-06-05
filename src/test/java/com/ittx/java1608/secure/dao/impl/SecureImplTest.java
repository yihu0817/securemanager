//package com.ittx.java1608.secure.dao.impl;
//
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.ittx.java1608.secure.dao.SecureDao;
//import com.ittx.java1608.secure.model.Function;
//import com.ittx.java1608.secure.model.Module;
//import com.ittx.java1608.secure.model.Role;
//import com.ittx.java1608.secure.model.User;
//import com.ittx.java1608.secure.utils.Configes;
//import com.ittx.java1608.secure.utils.Util;
//
//public class SecureImplTest {
//	private SecureDao secureDao;
//
//	@Before
//	public void setUp() throws Exception {
//		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring-core.xml" });
//		secureDao = (SecureDao) context.getBean("secureDao");
//	}
//
//	@Test
//	public void testAddRole() {
//		Role role = new Role("二级管理员","管理权限模块");
//		secureDao.addRole(role);
//	}
//
//	@Test
//	public void testGetRoleAll() {
//		List<Role> roleLists = secureDao.getRoleAll();
//		for(Role r : roleLists){
//			System.out.println(r.getName());
//		}
//	}
//
//	@Test
//	public void testDeleteRole() {
//		Role role = secureDao.getRoleById(1);
//		secureDao.deleteRole(role);
//	}
//
//	@Test
//	public void testAddModule() {
//		Module module = new Module("用户管理1", "对用户信息进行管理1");
//		secureDao.addModule(module);
//	}
//	
//	@Test
//	public void testGetModuleAll(){
//		List<Module> moduleLists  = secureDao.getModuleAll();
//		for(Module m : moduleLists){
//			System.out.println(m.getModuleName());
//		}
//	}
//
//	@Test
//	public void testGetModuleById() {
//		Module module = secureDao.getModuleById(1);
//		System.out.println(module.getModuleName());
//
//		List<Function> functionLists = Util.setToList(module.getFunctionSets());
//		for (Function f : functionLists) {
//			System.out.println(f.getFunctionCode() + "    " + f.getFunctionDescrition());
//		}
//	}
//
//	@Test
//	public void testDeleteModule() {
//		Module module = secureDao.getModuleById(1);
//		secureDao.deleteModule(module);
//	}
//
//	@Test
//	public void testAddFunction() {
//		Module module = secureDao.getModuleById(1);
//		Function function = new Function("useradd.do", "添加用户功能");
//		function.setModule(module);
//		secureDao.addFunction(function);
//	}
//
//	@Test
//	public void testGetAllFunction() {
//		List<Function> functionLists = secureDao.getAllFunction();
//		for (Function f : functionLists) {
//			System.out.println(f.getFunctionCode() + "    " + f.getFunctionDescrition());
//		}
//	}
//	
//	@Test
//	public void testAddUser(){
//		User user = new User("admin","123",Configes.CHECK_STATE_NO);
//		secureDao.addUser(user);
//	}
//	
//	@Test
//	public void testCheckUser(){
//		Role role = secureDao.getRoleById(1);
//		User user = secureDao.getUserById(1);
//		user.setState(Configes.CHECK_STATE_YES);
//		user.setRole(role);
//		secureDao.checkUser(user);
//	}
//	
//	
//}
