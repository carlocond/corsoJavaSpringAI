package com.azienda.esempioSpringData.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.azienda.esempioSpringData.service.AppService;

@SpringBootApplication(scanBasePackages = {"com.azienda.esempioSpringData.service"})
@EnableJpaRepositories(basePackages = {"com.azienda.esempioSpringData.repo"})
@EntityScan(basePackages = {"com.azienda.esempioSpringData.model"})
public class EsempioSpringDataApplication {

	public static void main(String[] args) {
		
		try (ConfigurableApplicationContext context = SpringApplication.run(EsempioSpringDataApplication.class, args)) {
			
			/*
			String[] beanNames = context.getBeanDefinitionNames();
			for (String s : beanNames) {
				System.out.println(s);
			}
			 */
			
			AppService service = context.getBean("appService", AppService.class);
			
//			service.savePersonaLavoratore("Mario", "Rossi", 1, 1100f);
//			
//			service.savePersonaLavoratore("Laura", "Verdi", 2, 2200f);
//			
//			System.out.println("ELENCO DELLE PERSONE");
//			service.getAllPersone().forEach(System.out::println);
//			
//			System.out.println("ELENCO DEI LAVORATORI");
//			service.getAllLavoratori().forEach(System.out::println);
//			
//			System.out.println("LAVORATORE CON ID = 2: " + service.getPersonaById(2));
//			
//			service.updatePersonaById(1, "Carlo", "Bianchi");
//			service.deleteLavoratoreById(1);
			
			//service.saveSede("Roma");
			//service.assunzione(2, 2000f, "Roma");
			
			//service.getLavoratoreByStipendioBetween(1000f, 3000f);
			//service.getSede("Roma");
			
			service.saveRuolo("Developer");
			service.assegnaRuolo(3, 3000f, "Developer");
			//service.getLavoratoreByStipendioBetween(1000f, 4000f);
			service.getRuolo("Developer");
			
			
			
			System.out.println();
			
			System.out.println("Setup OK!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
