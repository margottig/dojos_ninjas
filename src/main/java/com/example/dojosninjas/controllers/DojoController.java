package com.example.dojosninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dojosninjas.models.Dojo;
import com.example.dojosninjas.services.MainService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	
	@Autowired
	private MainService mainService;
	
	@GetMapping("/dojos")
	public String index(Model viewModel) {
		viewModel.addAttribute("dojos", mainService.todosDojos());
		return "/dojos/index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String formularioDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/nuevodojo.jsp";
	}
	@PostMapping("/dojos/new")
	public String nuevoDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "/dojos/nuevodojo.jsp";
		}
		mainService.crearDojo(dojo);
		return "redirect:/dojos";
	}
	
	@GetMapping("/dojo/{idDojo}")
	public String dojosYNinjas(@PathVariable("idDojo") Long idDojo, Model viewModel) {
		viewModel.addAttribute("dojosyninjas", mainService.encontrarDojo(idDojo) );
		return "/dojos/mostrardojo.jsp";
	}
	
	

}
