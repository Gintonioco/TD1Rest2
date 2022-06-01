package com.inti.TD1Rest2.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.inti.TD1Rest2.model.Etudiant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) //on va utiliser hibernate et pas une base en interne
public class EtudiantRepositoryTest
{
	@Autowired
	EtudiantRepository etudiantRepository;
	
	Etudiant e1;
	
	@BeforeEach
	public void setUp()
	{
		e1 = new Etudiant("Toto", "Titi", "tototiti@test.fr", "080709060405", 2021);
	}
	
	@Test
	public void testSaveStudent()
	{
		//Given
		
		//When
		Etudiant saveEtudiant = etudiantRepository.save(e1);
		
		//Then
		assertThat(saveEtudiant).isNotNull();	//on vérifie que l'étdiant sauvegardé n'est pas nul
		
	}
	
	@Test
	public void testGetAllStudents()
	{
		//Given
		
		//When
		List<Etudiant> listeEtudiant = etudiantRepository.findAll();
		
		//Then
		assertThat(listeEtudiant).isNotEmpty(); //tester si notre lise est vide ou pas
		assertThat(listeEtudiant).hasSize((int) etudiantRepository.count());
	}
	
	@Test
	public void testGetAllStudentsInLyon()
	{
		//Given
		
		//When
		List<Etudiant> listeEtudiant = etudiantRepository.findByVille();
		
		//Then
		assertThat(listeEtudiant).isNotEmpty(); //tester si notre lise est vide ou pas
		assertThat(listeEtudiant).hasSize((int) etudiantRepository.count());
		assertThat(listeEtudiant.get(0).getEcole().getVille()).isEqualTo("Lyon");
	}
}
