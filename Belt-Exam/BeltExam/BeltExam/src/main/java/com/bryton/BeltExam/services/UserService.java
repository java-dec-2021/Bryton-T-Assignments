package com.bryton.BeltExam.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bryton.BeltExam.models.Idea;
import com.bryton.BeltExam.models.User;
import com.bryton.BeltExam.repositories.IdeaRepository;
import com.bryton.BeltExam.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private IdeaRepository ideaRepo;
	
//	public List<User> getAllUsers(){
//		return this.userRepo.findAll();
//	}
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	//Register user after hashing PW
	public User registerUser(User user) {
		String hashedPass = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashedPass);
		System.out.println(user + " was created");
		return userRepo.save(user);
	}
	
	//Find user by email
	public User findByEmail(String email) {
		System.out.println("Server searched for User by Email: " + email);
		return userRepo.findByEmail(email);
	}
	
	//Find user by ID
	public User findById(Long id) {
		System.out.println("Server searched for User by Id: " + id);
		return userRepo.findById(id).orElse(null);
	}
	
	//Authenticate User
	public boolean authenticateUser(String email, String password) {
		User user = userRepo.findByEmail(email);
		//Checking if user is in DB
		if(user == null) {
			System.out.println("Server could not authenticate user is in DB");
			return false;
		} else {
			//Checking if entered PW is same in DB
			if(BCrypt.checkpw(password, user.getPassword())) {
				System.out.println("Passwords match");
				return true;
			} else {
				System.out.println("Psswords do not match");
				return false;
			}
		}
	}
	
	//Add like
	public void like(User user, Idea idea) {
		idea.getLikedBy().add(user);
		ideaRepo.save(idea);
		System.out.println(user + " just liked: " + idea);
	}
	
	//Remove Like
	public void unlike(User user, Idea idea) {
		idea.getLikedBy().remove(user);
		ideaRepo.save(idea);
		System.out.println(user + " just unliked: " + idea);
	}
	
}
