package com.ittx.java1608.secure.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ittx.java1608.secure.dao.UserDao;
import com.ittx.java1608.secure.model.User;
import com.ittx.java1608.secure.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public void checkUser(User user) {
		userDao.checkUser(user);
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public List<User> getUserAll() {
		return userDao.getUserAll();
	}

	@Override
	public User checkUser(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.checkUser(username, password);
	}

}
