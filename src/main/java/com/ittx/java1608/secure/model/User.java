package com.ittx.java1608.secure.model;

public class User {
	private int id;
	private String name;
	private String password;
	private int state;
	private Role role;

	public User() {
	}

	public User(String name, String password, int state) {
		this.name = name;
		this.password = password;
		this.state = state;
	}

	public User(int id, String name, String password, int state){ 
		this.id = id;
		this.name = name;
		this.password = password;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", state=" + state 
				+ "]";
	}

}
