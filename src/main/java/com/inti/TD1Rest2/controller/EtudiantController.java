package com.inti.TD1Rest2.controller;

import java.util.List;

import com.inti.TD1Rest2.model.Etudiant;
import com.inti.TD1Rest2.repository.EtudiantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
//	@GetMapping("/students")
//	public List<Etudiant> displayAllStudents()
//	{
//		return etudiantRepository.findAll();
//	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Etudiant>> getAllStudents()
	{
		return new ResponseEntity<List<Etudiant>>(etudiantRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/saveStudent")
	public ResponseEntity<Etudiant> saveStudent(@RequestBody Etudiant etudiant)
	{
		return new ResponseEntity<Etudiant>(etudiantRepository.save(etudiant), HttpStatus.CREATED);
	}
}