package com.esprit.produit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//import javax.validation.Valid;

import com.esprit.produit.repository.ProduitRepository;
import com.esprit.produit.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.produit.entity.Produit;


@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/api")
public class ProduitController {
	
	@Autowired
	ProduitRepository repository;
	
	@GetMapping("/produits")
	public List<Produit> getAllProduits(){
		System.out.println("Get All produits ....");
		
		List<Produit> Produits = new ArrayList<Produit>();
		repository.findAll().forEach(Produits :: add);
		return Produits;
	}
	
	@GetMapping("/produits/{id}")
	public ResponseEntity<Produit> getArticleById(@PathVariable(value = "id") Long articleId)
	throws ResourceNotFoundException {
		Produit article = repository.findById(articleId)
				.orElseThrow(() -> new ResourceNotFoundException("Produit not found for this id ::"+articleId));
		return ResponseEntity.ok().body(article);
	}
	
	@PostMapping("/Produits")
	public Produit createProduit(@RequestBody Produit produits){
		return repository.save(produits);
	}
	
	@DeleteMapping("/Produits/{id}")
	public Map<String, Boolean> deleteProduit(@PathVariable(value = "id") Long produitId)
		throws ResourceNotFoundException{
		Produit produit = repository.findById(produitId)
				.orElseThrow(() -> new ResourceNotFoundException("produits not fond id ::"+ produitId));
		repository.delete(produit);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@DeleteMapping("/produits/delete")
	public ResponseEntity<String> deleteAllProduits(){
		System.out.println("Delete All articles");
		repository.deleteAll();
		return new ResponseEntity<>("All produits have been deleted!", HttpStatus.OK);
	}
	
	@PutMapping("/produits/{id}")
	public ResponseEntity<Produit> updateArticle(@PathVariable("id") long id,
												 @RequestBody Produit Article){
		System.out.println("update produits with Id =" + id + " .....");
		
		Optional<Produit> produitInfo = repository.findById(id);
		
		if(produitInfo.isPresent()){
			Produit produit = produitInfo.get();
			produit.setCode(produit.getCode());
			produit.setLibelle(produit.getLibelle());


			produit.setId_cat(produit.getId_cat());
			produit.setId_scat(produit.getId_scat());
			
			return new ResponseEntity<>(repository.save(produit), HttpStatus.OK);
	
	}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

}
