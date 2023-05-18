package com.example.dojosninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.dojosninjas.repositories.NinjaRepo;

@Controller
public class NinjaController {
	
	@Autowired
	private NinjaRepo ninjaRepo;

}
