package com.bryton.dojos_and_ninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bryton.dojos_and_ninjas.models.Ninja;
import com.bryton.dojos_and_ninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepo;
	
	//Get all ninjas in a dojo
	public List<Ninja> getAllNinjasByDojo() {
		return this.ninjaRepo.findAll();
	}
	
	public void save(Ninja ninja) {
		ninjaRepo.save(ninja);
	}
	
	public void delete(Long id) {
		ninjaRepo.deleteById(id);
	}

}
