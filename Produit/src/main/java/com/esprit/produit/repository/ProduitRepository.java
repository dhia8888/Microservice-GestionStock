package com.esprit.produit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.esprit.produit.entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{
	
}
