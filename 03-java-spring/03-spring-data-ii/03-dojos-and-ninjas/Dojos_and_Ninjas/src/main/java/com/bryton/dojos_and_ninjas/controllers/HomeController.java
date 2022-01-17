package com.bryton.dojos_and_ninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bryton.dojos_and_ninjas.models.Dojo;
import com.bryton.dojos_and_ninjas.services.DojoService;

@Controller
public class HomeController {
	
	@Autowired
	private DojoService dojoService;
		
	//all dojos lists
	@GetMapping("/")
	public String getDojos(Model model) {
		model.addAttribute("dojos", this.dojoService.getAllDojos());
		return "NewDojo.jsp";
	}
	
	//create dojo
	@PostMapping("/create/dojo")
	public String createDojos(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println(result.getFieldError().getDefaultMessage());
			model.addAttribute("error", result.getFieldError().getDefaultMessage());
			return "NewDojo.jsp";
		} else {
			dojoService.create(dojo);
			return "redirect:/";
		}	
	}
	
	//shows dojo details
	@GetMapping("/dojo/${id}")
	public String getNinjasInDojo(@PathVariable("id") Long id) {
		return "DojoPage.jsp";
	}
	
	//delete dojo
	@DeleteMapping("/delete/${id}")
	public String deleteLanguage(@PathVariable("id") Long id) {
		dojoService.delete(id);
		return "redirect:/";
	}
	
	//edit dojo
//	@GetMapping("/dojo/{id}/edit")
//	public String editLanguage(@PathVariable("id") Long id , Model model) {
//		Dojo dojo = dojoService.getDojoById(id);
//		model.addAttribute("dojo", dojo);
//		return "editDojo.jsp";
//	}
}
