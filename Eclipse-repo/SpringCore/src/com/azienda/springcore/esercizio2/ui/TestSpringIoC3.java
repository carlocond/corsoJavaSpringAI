package com.azienda.springcore.esercizio2.ui;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.azienda.springcore.esempio.config.SpringConfiguration;
import com.azienda.springcore.esercizio.model.Banca;
import com.azienda.springcore.esercizio.model.ContoCorrente;

public class TestSpringIoC3 {

	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class)) {

            ContoCorrente conto1 = ctx.getBean("contoCorrente", ContoCorrente.class); // @Component
            ContoCorrente conto2 = ctx.getBean("conto2", ContoCorrente.class);         // @Bean config

            System.out.println("=== CONTO 1 (@Component) ===");
            System.out.println(conto1);

            System.out.println("=== CONTO 2 (@Bean conto2) ===");
            System.out.println(conto2);

            Banca banca1 = conto1.getBanca();
            Banca banca2 = conto2.getBanca();
            
            boolean verifica = (banca1.getIndirizzo().getComune().equals(banca2.getIndirizzo().getComune())) && 
            		(banca1.getIndirizzo().getStradaPiazza().equals(banca2.getIndirizzo().getStradaPiazza())) &&
            		(banca1.getIndirizzo().getNumeroCivico() == banca2.getIndirizzo().getNumeroCivico());

            System.out.println("\n=== VERIFICHE ===");
            System.out.println("Banche istanze diverse? " + (banca1 != banca2));
            System.out.println("Nome banca uguale? " + banca1.getNome().equalsIgnoreCase(banca2.getNome())); // qui atteso false (Unicredit vs Intesa)
            System.out.println("Indirizzo uguale per valori? " + verifica);

            System.out.println("Numero conto diverso? " + !conto1.getNumero().equals(conto2.getNumero()));
        }

	}

}
