package com.bryton.BeltExam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bryton.BeltExam.models.Idea;
import com.bryton.BeltExam.models.User;
import com.bryton.BeltExam.services.IdeaService;
import com.bryton.BeltExam.services.UserService;

@Controller
@RequestMapping("/ideas")
public class IdeasController {
	
	@Autowired
	private IdeaService	IdeaService;
	@Autowired
	private UserService UserService;
	
	//Render All Ideas page
	@GetMapping("")
	public String allIdeas(HttpSession session, Model model) {
		Long user_id=(Long)session.getAttribute("userId");
		User user=UserService.findById(user_id);
		model.addAttribute("User", user);
		model.addAttribute("Ideas", this.IdeaService.getAllIdeas());
		System.out.println("Server:Controller rendered allIdeas.jsp");
		return "allIdeas.jsp";
	}
	
	//Make a like
	@GetMapping("/{idea_id}/like")
	public String createLike(@PathVariable("idea_id") Long idea_id, HttpSession session, Model model) {
		Long user_id=(Long)session.getAttribute("userId");
		User user=UserService.findById(user_id);
		Idea idea=IdeaService.findById(idea_id);
		UserService.like(user,idea);
		model.addAttribute("User", user);
		model.addAttribute("Ideas", this.IdeaService.getAllIdeas());
		System.out.println("Server:Controller redirected user to /ideas");
		return "redirect:/ideas";
	}
	
	//Remove a like
	@GetMapping("/{idea_id}/unlike")
	public String unlike(@PathVariable("idea_id") Long idea_id, HttpSession session, Model model) {
		Long user_id=(Long)session.getAttribute("userId");
		User user=UserService.findById(user_id);
		Idea idea=IdeaService.findById(idea_id);
		UserService.unlike(user,idea);
		model.addAttribute("User", user);
		model.addAttribute("Ideas", this.IdeaService.getAllIdeas());
		System.out.println("Server:Controller redirected user to /ideas");
		return "redirect:/ideas";
	}
	
	//Render New Ideas Form Page
	@GetMapping("/new")
	public String newIdea(@ModelAttribute("idea") Idea idea, HttpSession session, Model model) {
		if(session.getAttribute("userId")!=null) {
			User user=UserService.findById((Long)session.getAttribute("userId"));
	// or 	Long user_id=(Long)session.getAttribute("userId");
	//		User user=UserService.findById(user_id);
			model.addAttribute("User", user);
			System.out.println("Server:Controller rendered newIdea.jsp");
			return "newIdea.jsp";
		} else {
			System.out.println("Server:Controller redirected user to /ideas");
			return "redirect:/";
		}
	}
	
	//Create New Idea
	@PostMapping("/new")
	public String createCategory(@Valid @ModelAttribute ("idea") Idea idea, BindingResult result){
		if(result.hasErrors()) {
			System.out.println("Server:Controller there were errors in creating new idea, returning to newIdea.jsp");
			return "newIdea.jsp";
		} else {
			this.IdeaService.createIdea(idea);
			System.out.println("Server:Controller redirected user to /ideas");
			return "redirect:/ideas";
		}
	}
	
	//Show Idea Page
	@GetMapping("/{id}")
	public String showIdea(@PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId")!=null) {
			Idea idea=IdeaService.findById(id);
			Long user_id=(Long)session.getAttribute("userId");
			User user=UserService.findById(user_id);
			model.addAttribute("User", user);
			model.addAttribute("Idea", idea);
			System.out.println("Server:Controller rendering showIdea.jsp");
			return "showIdea.jsp";
		} else {
			System.out.println("Server:Controller not in session returning to sign up");
			return "redirect:/";
		}
	}
	
	//Edit Idea
	@GetMapping("/{id}/edit")
	public String editIdea(@PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId")!=null) {
			Idea idea=IdeaService.findById(id);
			Long user_id=(Long)session.getAttribute("userId");
			User user=UserService.findById(user_id);
			model.addAttribute("User", user);
			model.addAttribute("Idea", idea);
			System.out.println("Server:Controller rendering editIdea.jsp");
			return "editIdea.jsp";
		} else {
			System.out.println("Server.Controller not in session, redirecting to sign up");
			return "redirect:/";
		}
	}

	//Update Idea
	@PostMapping("/{id}/edit")
	public String updateIdea(@Valid @PathVariable("id") Long id, @ModelAttribute ("Idea") Idea idea, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Server:Controller there were errors in updating idea, returning to editIdea.jsp");
			return "editIdea.jsp";
		} else {
			this.IdeaService.updateIdea(idea);
			System.out.println("Server:Controller updated idea");
			return "redirect:/ideas/{id}";
		}
	}
	
	//Delete Idea
	@GetMapping("/{id}/delete")
	public String deleteIdea(@PathVariable("id") Long id) {
		this.IdeaService.deleteIdea(id);
		System.out.println("Server:Controller redirected user to /ideas");
		return "redirect:/ideas";
	}
}
