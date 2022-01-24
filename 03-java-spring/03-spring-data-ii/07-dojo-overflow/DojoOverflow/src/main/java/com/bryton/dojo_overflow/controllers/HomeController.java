package com.bryton.dojo_overflow.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bryton.dojo_overflow.models.Answer;
import com.bryton.dojo_overflow.models.Question;
import com.bryton.dojo_overflow.models.Tag;
import com.bryton.dojo_overflow.services.AnswerService;
import com.bryton.dojo_overflow.services.QuestionService;
import com.bryton.dojo_overflow.services.TagService;

@Controller
public class HomeController {
	@Autowired
	private QuestionService questionServ;
	@Autowired
	private AnswerService answerServ;
	@Autowired
	private TagService tagServ;
	
	@GetMapping("/questions")
	public String dashboard(@ModelAttribute("show") Question question, Tag t, Model model) {
		model.addAttribute("allQuestions", questionServ.getAllQuestion());
		model.addAttribute("allTags",tagServ.getAllTag() );
		return "dashboard.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("newQuestion") Question question,Tag tag) {
		return "newquestion.jsp";
	}
	
	@PostMapping("questions/new")
	public String createQuestion(@Valid @ModelAttribute("newQuestion") Question question, BindingResult results) {
		System.out.println(question.toString());
		if(results.hasErrors()) {
			return "newquestion.jsp";
		}else {
			questionServ.createQuestion(question);
			return "redirect:/questions";
		}
	}
	
	@GetMapping("/questions/{id}")
	public String questiondetails( @PathVariable("id") Long id, Model model, @ModelAttribute("newAnswer") Answer answer) {
		Question question = questionServ.getOneQuestion(id);
		model.addAttribute("question", question);
		return "displayanswers.jsp";
	}
	
	@PostMapping("/questions/save")
	public String saveanswer(@Valid @ModelAttribute("newAnswer") Answer answer,BindingResult results) {
		System.out.println(answer.toString());
		if(results.hasErrors()) {
			return "displayanswers.jsp";
		}else {
			answerServ.saveAnswer(answer);
			return "redirect:/questions/" + answer.getQuestion().getId();
		}
	}
}
