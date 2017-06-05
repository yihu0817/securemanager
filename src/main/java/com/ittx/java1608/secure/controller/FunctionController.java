package com.ittx.java1608.secure.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ittx.java1608.secure.model.Function;
import com.ittx.java1608.secure.model.Module;
import com.ittx.java1608.secure.service.SecureService;


@Controller
@RequestMapping("/function")
public class FunctionController {
	@Autowired
	private SecureService secureService;

	//function/listfunction.do
	@RequestMapping(value = "/listfunction")
	public String listFunction(Integer moduleid,Map<String, List<Function>> map,Model model) {
		List<Function> functionLists = secureService.getFunction(moduleid);
		map.put("moduleFunctionList", functionLists);
		model.addAttribute("moduleid", moduleid);
		return "function/listfunction";
	}
	
	
	@RequestMapping(value="/addmodulefunction")
	public String addModuleFunction(Integer moduleid,String function_code,String description){
		Module module = secureService.getModuleById(moduleid);
		Function function = new Function(function_code,description);
		function.setModule(module);
		System.out.println("moduleid :"+moduleid + "  ,function_code :"+function_code + " description :"+description);
		secureService.addFunction(function);
		return "redirect:/function/listfunction.do?moduleid="+moduleid;
	}

}
