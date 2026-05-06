package com.azienda.esercizio1SpringData.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.azienda.esercizio1SpringData.model.Profilo;
import com.azienda.esercizio1SpringData.model.Utente;
import com.azienda.esercizio1SpringData.service.ProfiloService;
import com.azienda.esercizio1SpringData.service.UtenteService;

@SpringBootApplication
@ComponentScan(basePackages = {"com.azienda.esercizio1SpringData.repository",
								"com.azienda.esercizio1SpringData.model",
								"com.azienda.esercizio1SpringData.service"})
@EnableJpaRepositories(basePackages = "com.azienda.esercizio1SpringData.repository")
@EntityScan(basePackages = "com.azienda.esercizio1SpringData.model")
public class Esercizio1SpringDataApplication {

	public static void main(String[] args) {
		
		try (ConfigurableApplicationContext context = SpringApplication.run(Esercizio1SpringDataApplication.class, args)) {
			
			UtenteService serviceU = context.getBean(UtenteService.class);
			ProfiloService serviceP = context.getBean(ProfiloService.class);

            Profilo admin = serviceP.saveProfiloAdmin();
            System.out.println("Profilo creato: " + admin);

            Profilo user = serviceP.saveProfiloUser();
            System.out.println("Profilo creato: " + user);

            Utente u1 = serviceU.saveUtente("mariorossi", "pass1234", admin.getNome());
            System.out.println("Utente creato");

            Utente u2 = serviceU.saveUtente("laurabianchi", "ciao123", user.getNome());
            System.out.println("Utente creato");

            System.out.println("Login mario/pass1234: " + serviceU.login("mariorossi", "pass1234"));
            System.out.println("Login mario/sbagliata:  " + serviceU.login("mariorossi", "sbagliata"));

            System.out.println("mario è admin? " + serviceU.isAdmin("mariorossi", "pass1234"));
            System.out.println("laura è admin?  " + serviceU.isAdmin("laurabianchi", "ciao123"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
