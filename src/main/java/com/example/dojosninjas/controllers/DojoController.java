package com.example.dojosninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.dojosninjas.services.MainService;

@Controller
public class DojoController {
	
	@Autowired
	private MainService mainService;
	
	@GetMapping("/dojos")
	public String index(Model viewModel) {
		viewModel.addAttribute("dojos", mainService.todosDojos());
		return "/dojos/index.jsp";
	}

}
