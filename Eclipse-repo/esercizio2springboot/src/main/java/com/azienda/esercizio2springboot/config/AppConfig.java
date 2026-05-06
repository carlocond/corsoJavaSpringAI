package com.azienda.esercizio2springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azienda.esercizio2springboot.impl.MacchinaImpl;
import com.azienda.esercizio2springboot.impl.PersonaImpl;
import com.azienda.esercizio2springboot.model.Macchina;
import com.azienda.esercizio2springboot.model.Persona;

@Configuration
public class AppConfig {

	@Bean("personaDefault")
    public Persona personaDefault() {
        return new PersonaImpl(1, "Mario", "Rossi");
    }

    @Bean("macchinaDefault")
    public Macchina macchinaDefault() {
        return new MacchinaImpl(100, "Fiat Panda", 1200);
    }
    
    @Bean("persona2")
    public Persona persona2() {
        return new PersonaImpl(2, "Luca", "Bianchi");
    }

    @Bean("macchina2")
    public Macchina macchina2() {
        return new MacchinaImpl(200, "Volkswagen Golf", 1600);
    }
	
}
