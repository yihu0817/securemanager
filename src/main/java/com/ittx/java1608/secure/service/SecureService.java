package com.ittx.java1608.secure.service;

import java.util.List;

import com.ittx.java1608.secure.model.Function;
import com.ittx.java1608.secure.model.Module;
import com.ittx.java1608.secure.model.Role;
import com.ittx.java1608.secure.model.User;

public interface SecureService {
	public User checkUser(User user);
	public void addModule(Module module);
	public List<Module> getModuleAll();
	public Module getModuleById(int moduleId);
	
	
	//==========function===============
	void addFunction(Function function);
	List<Function> getAllFunction();
	List<Function> getFunction(int moduleId);
	Function getFunctionById(int id);
	
	
	//===========role===============
		void addRole(Role role);
		List<Role> getAllRoles();
		Role getRoleById(int id);
		void updateRole(Role role);
}
