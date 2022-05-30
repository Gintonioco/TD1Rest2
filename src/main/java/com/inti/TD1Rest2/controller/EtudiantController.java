package com.inti.TD1Rest2.controller;

import com.inti.TD1Rest2.model.Etudiant;
import com.inti.TD1Rest2.repository.EtudiantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtudiantController
{
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@GetMapping("/test")
	public String helloWorld()
	{
		return "Hello World!";
	}
	
	@PostMapping("/saveEtudiant")
	public void saveEtudiant()
	{
		Etudiant e = new Etudiant("Jean");
		etudiantRepository.save(e);
	}
}
