package com.ittx.java1608.secure.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.ittx.java1608.secure.dao.SecureDao;
import com.ittx.java1608.secure.model.Function;
import com.ittx.java1608.secure.model.Module;
import com.ittx.java1608.secure.model.Role;
import com.ittx.java1608.secure.model.User;
import com.ittx.java1608.secure.utils.MyHibernateDaoSupport;
import com.ittx.java1608.secure.utils.Utils;

@Repository("secureDao")
public class SecureImpl extends MyHibernateDaoSupport implements SecureDao {

	@Override
	public void addModule(Module module) {
		getHibernateTemplate().save(module);
	}

	@Override
	public Module getModuleById(int id) {
		return getHibernateTemplate().get(Module.class, id);
	}

	@Override
	public void deleteModule(Module module) {
		getHibernateTemplate().delete(module);

	}

	@Override
	public void addFunction(Function function) {
		getHibernateTemplate().save(function);

	}

	@Override
	public List<Function> getAllFunction() {
		return (List<Function>) getHibernateTemplate().find("FROM Function");
	}
	
	@Override
	public void addRole(Role role) {
		getHibernateTemplate().save(role);
	}

	@Override
	public List<Role> getRoleAll() {
		return (List<Role>) getHibernateTemplate().find("FROM Role");
	}

	@Override
	public void deleteRole(Role role) {
		getHibernateTemplate().delete(role);
	}

	@Override
	public Role getRoleById(int id) {
		return getHibernateTemplate().get(Role.class, id);
	}



	@Override
	public List<Module> getModuleAll() {
		List list = getHibernateTemplate().find("From Module");
		if(list == null && list.size() ==0){
			return null;
		}else{
			return (List<Module>) getHibernateTemplate().find("From Module");
		}
	}

	@Override
	public List<Function> getFunction(int moduleId) {
		 Module module = getHibernateTemplate().get(Module.class, moduleId);
		 Set<Function> sets =  module.getFunctionSets();
		 return Utils.setToList(sets);
	}

	@Override
	public Function getFunctionById(int id) {
		return getHibernateTemplate().get(Function.class, id);
	}

	@Override
	public void updateRole(Role role) {
		getHibernateTemplate().update(role);
	}

	@Override
	public void updateModuleById(Module module) {
		getHibernateTemplate().update(module);
		
	}

}
