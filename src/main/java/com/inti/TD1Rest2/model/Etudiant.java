package com.inti.TD1Rest2.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
public class Etudiant
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private @NonNull String nom;
	private String prenom;
	private String email;
	private String telephone;
	private int anneeEtude;
	
	@ManyToOne 
	@JoinColumn(name="idEcole")
	@JsonIgnore
    private Ecole ecole;
	
	@ManyToMany
	@JoinTable(name = "Professeur_Etudiant",
				joinColumns = @JoinColumn(name = "idEtu"),
				inverseJoinColumns = @JoinColumn(name = "idProf"))
	@JsonIgnore
	List<Professeur> listeProfesseurs;
	
	public Etudiant(@NonNull String nom, String prenom, String email, String telephone, int anneeEtude)
	{
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.anneeEtude = anneeEtude;
	}
	
	
	
}
