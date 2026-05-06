package com.azienda.esercizio2SpringRest.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.azienda.esercizio2SpringRest.service",
										"com.azienda.esercizio2SpringRest.controller"})
@EnableJpaRepositories(basePackages = "com.azienda.esercizio2SpringRest.repository")
@EntityScan(basePackages = "com.azienda.esercizio2SpringRest.model")
public class Esercizio2SpringRestApplication {

	public static void main(String[] args) {
		
		try (ConfigurableApplicationContext context = SpringApplication.run(Esercizio2SpringRestApplication.class, args)) {
			
			System.out.println("Programma avviato");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Programma arrestato con errore");
		}
		
	}

}
