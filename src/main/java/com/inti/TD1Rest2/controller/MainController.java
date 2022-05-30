package com.inti.TD1Rest2.controller;

import java.util.List;

import com.inti.TD1Rest2.model.Utilisateur;
import com.inti.TD1Rest2.repository.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController
{
	@Autowired //injection de dépendance
	UtilisateurRepository utilisateurRepository;
	
	@GetMapping("/hello")
	public String hello()
	{
		return "Hello World";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET) //aucune difference avec GetMapping
	public List<Utilisateur> getAllUsers()
	{
		return utilisateurRepository.findAll();
	}
	
	@PostMapping("/save")
	public String saveUser()
	{
		Utilisateur u = new Utilisateur("login", "login");
		utilisateurRepository.save(u);
		return "L'utilisateur a bien été enregistré";
	}
}
