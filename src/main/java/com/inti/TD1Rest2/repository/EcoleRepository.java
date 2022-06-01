package com.inti.TD1Rest2.repository;

import com.inti.TD1Rest2.model.Ecole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EcoleRepository extends JpaRepository<Ecole, Integer>
{
	@Query(value = "select ec.* from etudiant e, ecole ec, where e.id_ecole = ec.id and e.email=:mail", nativeQuery = true)
	Ecole findSchoolByEmail(@Param("mail") String mail);
	
	@Query(value = "select  from etudiant e, ecole ec, where e.id_ecole = ec.id and e.prenom=:prenom and e.nom=:nom", nativeQuery = true)
	Ecole findSchoolByNomAndPrenom(@Param("nom") String nom, @Param("prenom") String prenom);
}
