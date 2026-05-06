package com.azienda.springcore.esercizio2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.azienda.springcore.esercizio.impl.IndirizzoImpl;
import com.azienda.springcore.esercizio.model.Banca;
import com.azienda.springcore.esercizio.model.ContoCorrente;
import com.azienda.springcore.esercizio.model.Indirizzo;
import com.azienda.springcore.esercizio2.impl.BancaImpl;
import com.azienda.springcore.esercizio2.impl.ContoCorrenteImpl;

@Configuration
@ComponentScan(basePackages = "com.azienda.springcore.esercizio2")
public class SpringConfiguration {
	
	@Bean
	public Indirizzo indirizzo2() {
		return new IndirizzoImpl("Roma", "Via Appia", 1);
	}
	
	@Bean
	public Banca banca2() {
		return new BancaImpl("Intesa",indirizzo2());
	}
	
	@Bean
	public ContoCorrente conto2() {
		return new ContoCorrenteImpl(87654321,banca2());
	}
	
	@Bean
	public ContoCorrente conto3() {
		return new ContoCorrenteImpl(54657657,new BancaImpl("Mediolanum",null));
	}

}
