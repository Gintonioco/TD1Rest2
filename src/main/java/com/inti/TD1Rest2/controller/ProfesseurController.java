package com.inti.TD1Rest2.controller;

import java.util.List;

import com.inti.TD1Rest2.model.Ecole;
import com.inti.TD1Rest2.model.Professeur;
import com.inti.TD1Rest2.repository.EcoleRepository;
import com.inti.TD1Rest2.repository.ProfesseurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfesseurController
{
	@Autowired
	ProfesseurRepository professeurRepository;
	
	@Autowired
	EcoleRepository ecoleRepository;
	
	@GetMapping("/professeurs")
	public ResponseEntity<List<Professeur>> getAllProf()
	{
		return new ResponseEntity<List<Professeur>>(professeurRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/saveProfesseur")
	public ResponseEntity<Professeur> saveProfesseur(@RequestBody Professeur professeur)
	{
		return new ResponseEntity<Professeur>(professeurRepository.save(professeur), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateProfesseur/{id}")
	public String updateProfesseur(@RequestBody Professeur professeur, @PathVariable int id)
	{		
		professeurRepository.save(professeur);
		return "school " + professeur + " updated";
	}
	
	@DeleteMapping("/deleteProfesseur")
	public String deleteProfesseur(@RequestParam("id") int id)
	{
		professeurRepository.deleteById(id);
		return "Professeur deleted";
	}
	
}
