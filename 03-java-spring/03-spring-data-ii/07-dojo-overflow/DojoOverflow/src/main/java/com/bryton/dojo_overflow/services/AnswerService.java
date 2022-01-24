package com.bryton.dojo_overflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bryton.dojo_overflow.models.Answer;
import com.bryton.dojo_overflow.models.Question;
import com.bryton.dojo_overflow.repositories.AnswerRepository;
import com.bryton.dojo_overflow.repositories.QuestionRepository;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepository answerRepo;
	@Autowired
	private QuestionRepository questionRepo;
	
	//Create
		public void createQuestion(Answer answer) {
			this.answerRepo.save(answer);
		}
		//Get All Question
		public List<Answer> getAllQuestion(){
			return this.answerRepo.findAll();
		}
		//Get One Question
		public Answer getOneQuestion(Long id) {
			return this.answerRepo.findById(id).orElse(null);
		}
		
		public void saveAnswer(Answer answer) {
			Question question = questionRepo.findById(answer.getQuestion().getId()).get();
			question.getAnswers().add(answer);
			this.answerRepo.save(answer);
		}
}
