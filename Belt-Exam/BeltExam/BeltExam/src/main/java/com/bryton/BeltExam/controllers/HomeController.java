package com.bryton.BeltExam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bryton.BeltExam.models.User;
import com.bryton.BeltExam.services.UserService;
import com.bryton.BeltExam.validator.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private UserService UserService;
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		System.out.println("Server:Controller rendered index.jsp");
		return "index.jsp";
	}
	
	//Register user POST
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			System.out.println("Server:Controller there were errors in registering user, returning to index.jsp");
			return "index.jsp";
		} else {
			User newUser=UserService.registerUser(user);
			session.setAttribute("userId", newUser.getId());
			System.out.println("Server:Controller redirecting to /ideas");
			return "redirect:/ideas";
		}
	}
	
	//Login Function
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		if(UserService.authenticateUser(email,password)) {
			User user=UserService.findByEmail(email);
			session.setAttribute("userId", user.getId());
			System.out.println("Server:Controller logged in as: " + email + " redirecting to /ideas");
			return "redirect:/ideas";
		} else {
			System.out.println("Server:Controller there were errors in logging on, returning to index.jsp");
			redirectAttributes.addFlashAttribute("error","Invalid user/pass");
			return "index.jsp";
		}
	}
	
	//Logout Function
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("Server:Controller User has logged out");
		return "redirect:/";
	}
	
}
