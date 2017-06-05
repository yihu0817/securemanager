package com.ittx.java1608.secure.service;

import java.util.List;

import com.ittx.java1608.secure.model.User;

public interface UserService {
	public void addUser(User user);
	public void checkUser(User user);
	public User getUserById(int id);
	public List<User> getUserAll();
	
	public User checkUser(String username,String password);
}
