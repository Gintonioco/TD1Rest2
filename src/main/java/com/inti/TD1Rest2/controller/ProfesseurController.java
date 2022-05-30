package com.inti.TD1Rest2.controller;

import com.inti.TD1Rest2.repository.ProfesseurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfesseurController
{
	@Autowired
	ProfesseurRepository professeurRepository;
	
	
	
}
