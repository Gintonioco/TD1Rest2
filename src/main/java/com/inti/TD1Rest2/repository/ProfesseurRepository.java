package com.inti.TD1Rest2.repository;

import java.util.List;

import com.inti.TD1Rest2.model.Etudiant;
import com.inti.TD1Rest2.model.Professeur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Integer>
{
	@Query(value = "select * from etuidant where id_ecole=:idEcole", nativeQuery = true)
	List<Professeur> findProfesseurByIdEcoleSortBySalaire(@Param("idEcole") int idEcole);
}
