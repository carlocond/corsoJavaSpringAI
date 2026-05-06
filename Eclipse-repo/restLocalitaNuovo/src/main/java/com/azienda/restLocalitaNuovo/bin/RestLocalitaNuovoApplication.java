package com.azienda.restLocalitaNuovo.bin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.azienda.restLocalitaNuovo"})
public class RestLocalitaNuovoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestLocalitaNuovoApplication.class, args);
	}

}
