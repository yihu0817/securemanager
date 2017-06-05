package com.ittx.java1608.secure.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ittx.java1608.secure.dao.UserDao;
import com.ittx.java1608.secure.model.User;
import com.ittx.java1608.secure.utils.MyHibernateDaoSupport;

@Repository("userDao")
public class UserDaoImpl extends MyHibernateDaoSupport implements UserDao {
	@Override
	public void addUser(User user) {
		getHibernateTemplate().save(user);
	}

	@Override
	public void checkUser(User user) {
		getHibernateTemplate().update(user);

	}

	@Override
	public List<User> getUserAll() {
		return (List<User>) getHibernateTemplate().find("From User");
	}

	@Override
	public User getUserById(int id) {
		return getHibernateTemplate().get(User.class, id);
	}

	@Override
	public User checkUser(String username, String password) {
		List list = getHibernateTemplate().find("From User WHERE name = ? and password = ?", new String[]{username,password});
		if(list != null && list.size() >= 1){
			return (User) list.get(0);
		}else{
			return null;
		}
	}
}
