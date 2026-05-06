package com.azienda.Esercizio1SpringMVC.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.azienda.Esercizio1SpringMVC.controller","com.azienda.esercizio1SpringMVC.service"})
@EntityScan(basePackages = {"com.azienda.Esercizio1SpringMVC.model"})
@EnableJpaRepositories(basePackages = {"com.azienda.Esercizio1SpringMVC.repository"})
public class Esercizio1SpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Esercizio1SpringMvcApplication.class, args);
	}

}
