package com.example.dojosninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dojosninjas.models.Dojo;
import com.example.dojosninjas.models.Ninja;
import com.example.dojosninjas.repositories.DojoRepo;
import com.example.dojosninjas.repositories.NinjaRepo;

@Service
public class MainService {
	
	@Autowired
	private DojoRepo dojoRepo;
	@Autowired 
	private NinjaRepo ninjaRepo;
	
	//CREATE 
	public Dojo crearDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Ninja crearNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	//READ
	public List<Dojo> todosDojos(){
		return dojoRepo.findAll();
	}
	public List<Ninja> todosNinjas(){
		return ninjaRepo.findAll();
	}
	
}
