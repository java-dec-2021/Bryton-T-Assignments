package com.bryton.ControllerAndViews.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bryton.ControllerAndViews.Models.User;

@Repository
public interface UserRepository extends CrudRepository <User, Long> {
	
	User findByEmail(String email);

}
