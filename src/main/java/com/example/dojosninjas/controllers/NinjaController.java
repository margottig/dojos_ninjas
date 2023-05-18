package com.example.dojosninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dojosninjas.models.Ninja;
import com.example.dojosninjas.services.MainService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	
	@Autowired
	private MainService mainService;
	
	
	@GetMapping("/ninja/new")
	public String formularioNinja(@ModelAttribute("ninja") Ninja ninja, Model viewModel) {
		viewModel.addAttribute("dojos", mainService.todosDojos());
		return "/ninjas/nuevoninja.jsp";
	}
	@PostMapping("/ninja/new")
	public String nuevDojo(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "/ninjas/nuevoninja.jsp";
		}
		mainService.crearNinja(ninja);
		return "redirect:/dojos";
	}

}
