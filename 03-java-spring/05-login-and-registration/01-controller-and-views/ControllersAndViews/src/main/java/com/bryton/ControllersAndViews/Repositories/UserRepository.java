package com.bryton.ControllersAndViews.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bryton.ControllersAndViews.Models.User;

@Repository
public interface UserRepository extends CrudRepository <User, Long> {
	
	User findByEmail(String email);

}
