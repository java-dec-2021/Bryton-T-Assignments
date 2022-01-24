package com.bryton.dojo_overflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bryton.dojo_overflow.models.Question;
import com.bryton.dojo_overflow.models.Tag;
import com.bryton.dojo_overflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepo;
	
	//Create
	public void createQuestion(Question question) {
		question.setTags(this.getTokens(question.getTemptags()));
		this.questionRepo.save(question);
	}
	//Get All Question
	public List<Question> getAllQuestion(){
		return this.questionRepo.findAll();
	}
	//Get One Question
	public Question getOneQuestion(Long id) {
		return this.questionRepo.findById(id).orElse(null);
	}
	
	private List<Tag> getTokens(String str) {
	    List<Tag> tags = new ArrayList<>();
	    StringTokenizer tokenizer = new StringTokenizer(str, ",");
	    while (tokenizer.hasMoreElements()) {
	    	Tag tag = new Tag();
	    	tag.setSubject(tokenizer.nextToken());
	        tags.add(tag);
	    }
	    return tags;
	}
}
