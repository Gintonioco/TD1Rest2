package com.inti.TD1Rest2.repository;

import com.inti.TD1Rest2.model.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>
{
	
}
