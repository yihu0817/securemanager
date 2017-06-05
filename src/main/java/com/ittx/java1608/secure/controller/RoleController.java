package com.ittx.java1608.secure.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ittx.java1608.secure.model.Function;
import com.ittx.java1608.secure.model.Role;
import com.ittx.java1608.secure.service.SecureService;
import com.ittx.java1608.secure.utils.Utils;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private SecureService secureService;
	
	@RequestMapping(value = "addrole")
	public String addRole(){
		return "role/addrole";
	}
	
	@RequestMapping(value = "rolesubmit")
	public String addRoleSubmit(Role role){
		secureService.addRole(role);
		return "redirect:/role/listrole";
	}
	
	//role/listrole
	@RequestMapping(value = "listrole")
	public String listRole(Map<String, List<Role>> map,Model model) {
		List<Role> roleLists = secureService.getAllRoles();
		map.put("roleLists", roleLists);
		return "role/listrole";
	}

	//role/listrolefunction.do
	@RequestMapping(value = "listrolefunction")
	public String listRole(Integer roleId, Map<String, List<Function>> map,Model model) {
		Role role  = secureService.getRoleById(roleId);
		List<Function> functionLists = Utils.setToList(role.getFunctionLists());//角色已经被赋予的功能列表
		
		List<Function> functionAllLists = secureService.getAllFunction();  //所有模块所有功能列表
		map.put("functionLists", functionLists);
		map.put("functionAllLists", functionAllLists);
		model.addAttribute("roleId", roleId);
		return "role/listfunction2";
	}
	
	@RequestMapping(value="submitfunction")
	public String submitfunction(Integer roleId,Integer[] selectId){
		Role role  = secureService.getRoleById(roleId);
		role.getFunctionLists().clear();  
	
		Set<Function> functionLists = new HashSet<Function>();
		for(Integer fId : selectId){
			Function function = secureService.getFunctionById(fId);
			functionLists.add(function);
		}
		role.setFunctionLists(functionLists);
		secureService.updateRole(role);
		
		return "redirect:/role/listrolefunction?roleId="+roleId;
	}
}
