package com.bryton.dojos_and_ninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bryton.dojos_and_ninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja,Long> {
	List<Ninja> findAll();
}
