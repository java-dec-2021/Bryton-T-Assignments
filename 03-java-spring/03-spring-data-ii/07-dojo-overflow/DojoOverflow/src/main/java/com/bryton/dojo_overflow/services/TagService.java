package com.bryton.dojo_overflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bryton.dojo_overflow.models.Tag;
import com.bryton.dojo_overflow.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tRepo;
	
	//create
	public void createTag(Tag tag) {
		this.tRepo.save(tag);
	}
	//Get All
	public List<Tag> getAllTag(){
		return this.tRepo.findAll();
	}
	//Get One
	
	public Tag getOndeTag(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
}
