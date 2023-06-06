package com.example.dojosninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.dojosninjas.models.Dojo;
import com.example.dojosninjas.models.Ninja;
import com.example.dojosninjas.repositories.DojoRepo;
import com.example.dojosninjas.repositories.NinjaRepo;
import com.example.dojosninjas.repositories.NinjaRepoPage;

@Service
public class MainService {
	
	@Autowired
	private DojoRepo dojoRepo;
	@Autowired 
	private NinjaRepo ninjaRepo;
	@Autowired
	private NinjaRepoPage ninjarepoPage;
	
	// variable para determinar cuantos registros por página
	private static final int PAGE_SIZE = 2;
	
	
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
	public Dojo encontrarDojo(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}
	
	
	//METODO PARA SEGMENTACION DE INFORMACION AKA PAGINATION
	public Page<Ninja> ninjasPorPag(int numeroPag){
		PageRequest solicitudPagina = PageRequest.of(numeroPag, PAGE_SIZE, Sort.Direction.ASC, "dojo.name");
		return ninjarepoPage.findAll(solicitudPagina);
		
	}
}
