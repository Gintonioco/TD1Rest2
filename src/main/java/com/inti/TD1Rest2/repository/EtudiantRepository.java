package com.inti.TD1Rest2.repository;

import com.inti.TD1Rest2.model.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer>
{

}
