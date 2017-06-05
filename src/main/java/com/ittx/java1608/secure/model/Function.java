package com.ittx.java1608.secure.model;

import java.util.Set;

public class Function {
	private int functionId;
	private String functionCode; // 功能代码
	private String functionDescrition;
	private Module module; 
	private Set<Role> roleSets;
	
	public Function() {
		super();
	}

	public Function(int functionId, String functionCode, String functionDescrition) {
		super();
		this.functionId = functionId;
		this.functionCode = functionCode;
		this.functionDescrition = functionDescrition;
	}

	public Function(String functionCode, String functionDescrition) {
		this.functionCode = functionCode;
		this.functionDescrition = functionDescrition;
	}
	
	public int getFunctionId() {
		return functionId;
	}

	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String getFunctionDescrition() {
		return functionDescrition;
	}

	public void setFunctionDescrition(String functionDescrition) {
		this.functionDescrition = functionDescrition;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Set<Role> getRoleSets() {
		return roleSets;
	}

	public void setRoleSets(Set<Role> roleSets) {
		this.roleSets = roleSets;
	}
}
