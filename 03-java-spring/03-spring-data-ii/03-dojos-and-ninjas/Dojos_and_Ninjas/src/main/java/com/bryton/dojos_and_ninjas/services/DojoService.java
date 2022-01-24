package com.bryton.dojos_and_ninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bryton.dojos_and_ninjas.models.Dojo;
import com.bryton.dojos_and_ninjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepo;
	
	//Get all dojos in repo
	public List<Dojo> getAllDojos() {
		return this.dojoRepo.findAll();
	}
	
	//Get dojo by ID
	public Dojo getDojoById(long id) {
		return dojoRepo.findById(id).get();
	}
	
	//Create dojo
	public Dojo create(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	//Delete dojo
	public void delete(Long id) {
		dojoRepo.deleteById(id);
	}
}
