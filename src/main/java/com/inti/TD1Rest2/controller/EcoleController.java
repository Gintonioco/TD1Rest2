package com.inti.TD1Rest2.controller;

import java.util.List;

import com.inti.TD1Rest2.model.Ecole;
import com.inti.TD1Rest2.model.Etudiant;
import com.inti.TD1Rest2.repository.EcoleRepository;

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
public class EcoleController
{
	@Autowired
	EcoleRepository ecoleRepository;
	
	
	
	

	@GetMapping("/schools")
	public ResponseEntity<List<Ecole>> getAllShools()
	{
		return new ResponseEntity<List<Ecole>>(ecoleRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/saveSchool")
	public ResponseEntity<Ecole> saveEcole(@RequestBody Ecole ecole)
	{
		return new ResponseEntity<Ecole>(ecoleRepository.save(ecole), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateSchool/{id}")
	public String updateEcole(@RequestBody Ecole ecole, @PathVariable int id)
	{
//		Ecole e1 = ecoleRepository.getReferenceById(id);
		
		
		ecoleRepository.save(ecole);
		return "school " + ecole + " updated";
	}
	
	@DeleteMapping("/deleteSchool")
	public String deleteSchool(@RequestParam("id") int id)
	{
		ecoleRepository.deleteById(id);
		return "school deleted";
	}
	
	
	
	@GetMapping("/schoolByEmail/{email}")
	public Ecole getSchoolByEmail(@PathVariable String email)
	{
		return ecoleRepository.findSchoolByEmail(email);
	}
}
