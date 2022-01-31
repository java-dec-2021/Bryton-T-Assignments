package com.bryton.ControllerAndViews.Controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bryton.ControllerAndViews.Models.User;
import com.bryton.ControllerAndViews.Services.UserService;

// imports removed for brevity
@Controller
public class HomeController {
    private final UserService userService;
    
    public HomeController(UserService userService) {
        this.userService = userService;
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
			User newUser=userService.registerUser(user);
			session.setAttribute("userId", newUser.getId());
			return "redirect:/home";
		}
	}
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		if(userService.authenticateUser(email,password)) {
			User user=userService.findByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/ideas";
		} else {
			return "index.jsp";
		}
	}
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
		if(session.getAttribute("userId")!=null) {
			Long user_id=(Long)session.getAttribute("userId");
			User user=userService.findById(user_id);
			model.addAttribute("User", user);
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
		return "redirect:/";
	}
}
