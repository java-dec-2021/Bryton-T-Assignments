package com.bryton.languages.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bryton.languages.models.Language;
import com.bryton.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	@Autowired
	private LanguageRepository languageRepo;
	
//	public LanguageService(LanguageRepository languageRepo) {
//		this.languageRepo = languageRepo;
//	}
	
	//Get all languages
	public List<Language> getAllLanguages() {
		return this.languageRepo.findAll();
	}
	
	//Get language by ID
	public Language getLanguageById(long id) {
		return languageRepo.findById(id).get();
	}
	
	//Create language
	public void create(Language language) {
		languageRepo.save(language);
	}
	
	//Update language
	
	//Delete language
	public void delete(Long id) {
		languageRepo.deleteById(id);
	}

}
