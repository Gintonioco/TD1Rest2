package com.inti.TD1Rest2.repository;

import com.inti.TD1Rest2.model.Ecole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcoleRepository extends JpaRepository<Ecole, Integer>
{

}
