package com.bryton.BeltExam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bryton.BeltExam.models.Idea;
import com.bryton.BeltExam.repositories.IdeaRepository;

@Service
public class IdeaService {
	@Autowired
	private IdeaRepository ideaRepo;

	//Get all ideas
	public List<Idea> getAllIdeas(){
		System.out.println("Server retreived all Ideas");
		return ideaRepo.findAll();
	}
	
	//Create idea in DB
	public Idea createIdea(Idea idea) {
		System.out.println("Server created an Idea in DB: " + idea);
		return ideaRepo.save(idea);
	}
	
	//Update idea in DB
	public Idea updateIdea(Idea idea) {
		System.out.println("Server has updated an Idea in DB: " + idea);
		return ideaRepo.save(idea);
	}
	
	//Delete idea in DB
	public void deleteIdea(Long id) {
		System.out.println("Server has deleted an idea from DB where id = " + id);
		ideaRepo.deleteById(id);
	}
	
	//Find idea by ID
	public Idea findById(Long id) {
		System.out.println("Server found idea by Id where id: " + id);
		return ideaRepo.findById(id).orElse(null);
	}
}
