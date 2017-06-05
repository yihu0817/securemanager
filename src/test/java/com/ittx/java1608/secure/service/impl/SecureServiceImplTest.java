//package com.ittx.java1608.secure.service.impl;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.ittx.java1608.secure.model.Module;
//import com.ittx.java1608.secure.service.SecureService;
//
//public class SecureServiceImplTest {
//	private SecureService secureService;
//	@Before
//	public void setUp() throws Exception {
//		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring-core.xml" });
//		secureService = (SecureService) context.getBean("secureService");
//	}
//
//	@Test
//	public void testAddModule() {
//		Module module = new Module("权限管理", "对用户信息进行管理1");
//		secureService.addModule(module);
//	}
//
//	@Test
//	public void testGetModuleAll() {
//		secureService.getModuleAll();
//	}
//
//}
