package com.bryton.ControllersAndViews.Controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bryton.ControllersAndViews.Models.User;
import com.bryton.ControllersAndViews.Services.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService UserService;
 
	public void Users(UserService userService) {
		this.UserService = userService;
 	}
 
 	@RequestMapping("/registration")
 	public String registerForm(@ModelAttribute("user") User user) {
	 	return "registrationPage.jsp";
 	}
 	@RequestMapping("/login")
 	public String login() {
	 	return "loginPage.jsp";
 	}
 
 	@RequestMapping(value="/registration", method=RequestMethod.POST)
 	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
     // if result has errors, return the registration page (don't worry about validations just now)
     // else, save the user in the database, save the user id in session, and redirect them to the /home route
	 	if(result.hasErrors()) {
			return "registrationPage.jsp";
		} else {
			User newUser=UserService.registerUser(user);
			session.setAttribute("userId", newUser.getId());
			return "redirect:/home";
		}
	}
 
@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	 // if the user is authenticated, save their user id in session
	 // else, add error messages and return the login page
		if(UserService.authenticateUser(email,password)) {
			User user=UserService.findByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/home";
		} else {
			return "loginPage.jsp";
		}
	}
 
	@RequestMapping("/home")
 	public String home(HttpSession session, Model model) {
     // get user from session, save them in the model and return the home page
		if(session.getAttribute("userId")!=null) {
			Long user_id=(Long)session.getAttribute("userId");
			User user=UserService.findById(user_id);
			model.addAttribute("user", user);
			return "homePage.jsp";
		} else {
			return "redirect:/login";
		}
 	}
 
 	@RequestMapping("/logout")
 	public String logout(HttpSession session) {
     // invalidate session
     // redirect to login page
		session.invalidate();
		return "redirect:/login";
	}
	
}
