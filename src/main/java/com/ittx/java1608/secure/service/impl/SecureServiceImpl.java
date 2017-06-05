package com.ittx.java1608.secure.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ittx.java1608.secure.dao.SecureDao;
import com.ittx.java1608.secure.model.Function;
import com.ittx.java1608.secure.model.Module;
import com.ittx.java1608.secure.model.Role;
import com.ittx.java1608.secure.model.User;
import com.ittx.java1608.secure.service.SecureService;

@Service("secureService")
public class SecureServiceImpl implements SecureService {
	@Autowired
	private SecureDao secureDao;

	@Override
	public User checkUser(User user) {
		return null;
	}

	@Override
	public void addModule(Module module) {
		secureDao.addModule(module);
	}

	@Override
	public List<Module> getModuleAll() {
		return secureDao.getModuleAll();
	}

	@Override
	public void addFunction(Function function) {
		secureDao.addFunction(function);
	}

	@Override
	public List<Function> getAllFunction() {
		return secureDao.getAllFunction();
	}

	@Override
	public List<Function> getFunction(int moduleId) {
		return secureDao.getFunction(moduleId);
	}

	@Override
	public Function getFunctionById(int id) {
		return secureDao.getFunctionById(id);
	}

	@Override
	public Module getModuleById(int moduleId) {
		// TODO Auto-generated method stub
		return secureDao.getModuleById(moduleId);
	}

	@Override
	public void addRole(Role role) {
		secureDao.addRole(role);
		
	}

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return secureDao.getRoleAll();
	}

	@Override
	public Role getRoleById(int id) {
		// TODO Auto-generated method stub
		return secureDao.getRoleById(id);
	}

	@Override
	public void updateRole(Role role) {
		secureDao.updateRole(role);
		
	}

}
