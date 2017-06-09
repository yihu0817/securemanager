package com.ittx.java1608.secure.dao;

import java.util.List;

import com.ittx.java1608.secure.model.Function;
import com.ittx.java1608.secure.model.Module;
import com.ittx.java1608.secure.model.Role;
import com.ittx.java1608.secure.model.User;

public interface SecureDao {
	//=====modulefunction=====
	public void addModule(Module module);
	public Module getModuleById(int id);
	public List<Module> getModuleAll();
	public void deleteModule(Module module);
	public void updateModuleById(Module module);
	
	public void addFunction(Function function);
	public List<Function> getAllFunction();
	public List<Function> getFunction(int moduleId);
	public Function getFunctionById(int id);
	
	//====roleFunction=======
	public void addRole(Role role);
	public Role getRoleById(int id);
	public List<Role> getRoleAll();
	public void deleteRole(Role role);
	void updateRole(Role role);
	

	
	
}
