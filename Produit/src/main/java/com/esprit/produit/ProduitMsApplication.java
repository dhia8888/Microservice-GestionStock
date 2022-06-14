package com.esprit.produit;

import com.esprit.produit.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ProduitMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProduitMsApplication.class, args);
	}
	
	@Autowired
	private ProduitRepository repository;
	
	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// save
		};
	}

}
