package com.bryton.BeltExam.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bryton.BeltExam.models.User;

@Repository
public interface UserRepository extends CrudRepository <User, Long> {
	
	User findByEmail(String email);

}
