package com.ittx.java1608.secure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ittx.java1608.secure.model.Module;
import com.ittx.java1608.secure.service.SecureService;

@Controller
@RequestMapping("/module")
public class ModuleFunctionController {
	@Autowired
	private SecureService secureService;

	@RequestMapping("/listmodule")
	public String getModuleAll(Model model) {
		List<Module> moduleLists = secureService.getModuleAll();
		model.addAttribute("modulesList", moduleLists);
		return "module/listmodule";
	}
	
	@RequestMapping("/addmodule")
	public String addModule(){
		return "module/addmodule";
	}
	
	@RequestMapping("/addmodule_submit")
	public String addModuleSubmit(String name, String description) {
		Module module = new Module(name,description);
		secureService.addModule(module);
		return "redirect:listmodule";
	}

}
