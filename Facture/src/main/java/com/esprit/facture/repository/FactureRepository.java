package com.esprit.facture.repository;

import com.esprit.facture.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Long>{
	
	
}
