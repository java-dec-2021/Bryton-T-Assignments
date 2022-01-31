package com.bryton.ControllerAndViews.Services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bryton.ControllerAndViews.Models.User;
import com.bryton.ControllerAndViews.Repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	//Register user after hashing PW
	public User registerUser(User user) {
		String hashedPass = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashedPass);
		return userRepo.save(user);
	}
	
	//Find user by email
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	//Find user by ID
	public User findById(Long id) {
		return userRepo.findById(id).orElse(null);
	}
	
	//Authenticate User
	public boolean authenticateUser(String email, String password) {
		User user = userRepo.findByEmail(email);
		//Checking if user is in DB
		if(user == null) {
			return false;
		} else {
			//Checking if entered PW is same in DB
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
}
