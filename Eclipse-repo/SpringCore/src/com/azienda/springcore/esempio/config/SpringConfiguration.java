package com.azienda.springcore.esempio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.azienda.springcore.esempio.model.Stanza;

@Configuration
@ComponentScan(basePackages = {"com.azienda.springcore.esempio.model"})
public class SpringConfiguration {

	
	@Bean
	public Stanza stanza2() {
		return new Stanza("Salotto", "blu", 12f);
	}
	
	
}
