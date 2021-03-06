package com.bryton.languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bryton.languages.models.Language;
import com.bryton.languages.services.LanguageService;

@Controller
public class HomeController {
	
	@Autowired
	private LanguageService LanguageService;
		
	//all language lists
	@GetMapping("/")
	public String getLanguages(Model model) {
		List<Language> languages = LanguageService.getAllLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	//create language
	@PostMapping("/languages")
	public String createLanguages(Language language) {
		LanguageService.create(language);
		return "redirect:/";
		
	}
	//shows language details
	@GetMapping("/languages/{id}")
	public String getLanguagesid(@PathVariable("id") Long id,Model model) {
		Language language = LanguageService.getLanguageById(id);
		model.addAttribute("language", language);
		return "details.jsp";
	}
	//delete language
	@GetMapping("/delete/{id}")
	public String deleteLanguage(@PathVariable("id") Long id) {
		LanguageService.delete(id);
		return "redirect:/";
	}
	
	//edit language
	@GetMapping("/languages/{id}/edit")
	public String editLanguage(@PathVariable("id") Long id , Model model) {
		Language language = LanguageService.getLanguageById(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
			
		
		

}
