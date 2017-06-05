package com.ittx.java1608.secure.model;

import java.util.Set;

public class Module {
	private int moduleId;
	private String moduleName;
	private String moduleDescrition;
	private Set<Function> functionSets;
	
	public Module() {
		super();
	}
	public Module(int moduleId, String moduleName, String moduleDescrition) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.moduleDescrition = moduleDescrition;
	}
	
	public Module(String moduleName, String moduleDescrition) {

		this.moduleName = moduleName;
		this.moduleDescrition = moduleDescrition;
	}
	
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleDescrition() {
		return moduleDescrition;
	}
	public void setModuleDescrition(String moduleDescrition) {
		this.moduleDescrition = moduleDescrition;
	}
	public Set<Function> getFunctionSets() {
		return functionSets;
	}
	public void setFunctionSets(Set<Function> functionSets) {
		this.functionSets = functionSets;
	}
	
	
	
}
