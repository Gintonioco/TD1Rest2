package com.inti.TD1Rest2.controller;

import java.util.ArrayList;
import java.util.List;

import com.inti.TD1Rest2.model.Ecole;
import com.inti.TD1Rest2.model.Etudiant;
import com.inti.TD1Rest2.model.Professeur;
import com.inti.TD1Rest2.model.Utilisateur;
import com.inti.TD1Rest2.repository.EcoleRepository;
import com.inti.TD1Rest2.repository.EtudiantRepository;
import com.inti.TD1Rest2.repository.ProfesseurRepository;
import com.inti.TD1Rest2.repository.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController
{
	@Autowired //injection de dépendance
	UtilisateurRepository utilisateurRepository;
	
	@Autowired
	EcoleRepository ecoleRepository;
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Autowired
	ProfesseurRepository professeurRepository;
	
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
	
	@PutMapping("/updateEcoleProfesseur/{idEcole}/{idEcole}")
	public String updateStudentWithSchool(@PathVariable int idEcole, @PathVariable int idProf)
	{
		Ecole ecole = ecoleRepository.getReferenceById(idEcole);
		Professeur prof = professeurRepository.getReferenceById(idProf);
		
		List<Professeur> listProfesseurs = new ArrayList<Professeur>();
		
		listProfesseurs.add(prof);
		
//		ecole.setListeProfesseurs(listProfesseurs);
		
		ecoleRepository.save(ecole);
		
		return "student " + ecole + " saved";
		
//		etudiant.setEcole(ecole); //@RequestBody Etudiant etudiant
		
//		etudiantRepository.save(etudiant);
		
//		return "student" + etudiant + "has been updated";
	}
}
