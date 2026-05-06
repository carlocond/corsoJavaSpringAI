package com.azienda.esercizio2SpringData.ui;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.azienda.esercizio2SpringData.model.Banca;
import com.azienda.esercizio2SpringData.model.ContoCorrente;
import com.azienda.esercizio2SpringData.model.Persona;
import com.azienda.esercizio2SpringData.service.AppService;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.azienda.esercizio2SpringData.service",
        "com.azienda.esercizio2SpringData.repository"
})
@EnableJpaRepositories(basePackages = "com.azienda.esercizio2SpringData.repo")
@EntityScan(basePackages = "com.azienda.esercizio2SpringData.model")
public class Esercizio2SpringDataApplication {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = SpringApplication.run(Esercizio2SpringDataApplication.class, args)) {

            AppService service = context.getBean(AppService.class);

            Banca banca = new Banca("Banca Centrale");

            Persona p1 = new Persona("Mario", "Rossi");
            List<ContoCorrente> contiP1 = Arrays.asList(
                    new ContoCorrente("IT00X111", 1000.0f),
                    new ContoCorrente("IT00X112", 1500.0f)
            );
            service.create(p1, contiP1, banca);

            Persona p2 = new Persona("Laura", "Bianchi");
            List<ContoCorrente> contiP2 = Arrays.asList(
                    new ContoCorrente("IT00X211", 700.0f),
                    new ContoCorrente("IT00X212", 900.0f)
            );
            service.create(p2, contiP2, banca);

            service.spostaFondi("Mario", "Rossi", "Laura", "Bianchi", 100.0f);

            System.out.println("Operazioni completate.");
        }
	}

}
