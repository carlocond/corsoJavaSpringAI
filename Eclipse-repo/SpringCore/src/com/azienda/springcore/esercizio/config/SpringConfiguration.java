package com.azienda.springcore.esercizio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.azienda.springcore.esercizio.impl.BancaImpl;
import com.azienda.springcore.esercizio.impl.ContoCorrenteImpl;
import com.azienda.springcore.esercizio.impl.IndirizzoImpl;
import com.azienda.springcore.esercizio.model.Banca;
import com.azienda.springcore.esercizio.model.ContoCorrente;
import com.azienda.springcore.esercizio.model.Indirizzo;

@Configuration
@ComponentScan(basePackages = "com.azienda.springcore.esercizio")
public class SpringConfiguration {
	
	@Bean(name = "indirizzo2")
	public Indirizzo indirizzo2() {
		return new IndirizzoImpl("Roma", "Via Appia", 1);
	}
	
	@Bean(name = "banca2")
    public Banca banca2() {
        return new BancaImpl("Intesa", indirizzo2());
    }
	
	@Bean(name = "conto2")
    public ContoCorrente conto2() {
        return new ContoCorrenteImpl("87654321", banca2());
    }
	
	@Bean(name = "conto3")
    public ContoCorrente conto3() {
        Banca bancaNull = new BancaImpl("BancaSenzaIndirizzo", null);
        return new ContoCorrenteImpl("stringa", bancaNull);
    }

}
