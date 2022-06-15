package com.esprit.fournisseur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class FournisseurApplication {

	public static void main(String[] args) {
		SpringApplication.run(FournisseurApplication.class, args);
	}
	
	@Autowired
	private FournisseurRepository repository;
	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// save
			repository.save(new Fournisseur("fournisseur1", "fournisseur1", "tunis","fs65g4d","fournisseur1@gmail.com"));
			repository.save(new Fournisseur("fournisseur2", "fournisseur2", "tunis","88gfg4d","fournisseur2@gmail.com"));

			// fetch
			repository.findAll().forEach(System.out::println);

		};
	}

}
