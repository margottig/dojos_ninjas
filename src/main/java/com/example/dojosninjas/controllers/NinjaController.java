package com.example.dojosninjas.controllers;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	//RUTA PARA SEGMENTACION DE INFORMACION AKA PAGINATION
	@GetMapping("/pages/{numeroPagina}")
	public String obtenerNinjasPorPag(Model viewModel, @PathVariable("numeroPagina") int numeroPagina ) {
		Page<Ninja> ninjas = mainService.ninjasPorPag(numeroPagina -1);
		int totalPaginas = ninjas.getTotalPages();
		viewModel.addAttribute("totalpaginas", totalPaginas );
		viewModel.addAttribute("ninjas", ninjas);
		return "pagination.jsp";
	}
	
	@PostMapping("/ninja/new")
	public String nuevDojo(@Valid @ModelAttribute("ninja") Ninja ninja, 
			BindingResult resultado, 
			Model viewModel) {
		if(resultado.hasErrors()) {
			
			// LOG BindingResult errors
			System.out.println(ninja.getAge() + "IMPORTANTE" + resultado.getFieldErrors() );
						//Get error message
			Map<String, String> errors = resultado.getFieldErrors().stream()
					.collect(
							Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
							);
			System.out.println(errors + " AQUIQUIQUQUIQUIQ");
			
			viewModel.addAttribute("dojos", mainService.todosDojos());
			return "/ninjas/nuevoninja.jsp";
		}
		mainService.crearNinja(ninja);
		return "redirect:/dojos";
	}

}
