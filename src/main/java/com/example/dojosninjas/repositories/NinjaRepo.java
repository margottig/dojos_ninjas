package com.example.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.dojosninjas.models.Ninja;

public interface NinjaRepo extends CrudRepository<Ninja, Long>{

	List<Ninja> findAll();
}
