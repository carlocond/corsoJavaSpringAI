package com.azienda.springcore.esercizio.ui;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.azienda.springcore.esercizio.config.SpringConfiguration;
import com.azienda.springcore.esercizio.model.ContoCorrente;

public class TestSpringIoC2 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
			
			ContoCorrente contoComponent = context.getBean("contoCorrente", ContoCorrente.class);

	        ContoCorrente conto2 = context.getBean("conto2", ContoCorrente.class);
	        ContoCorrente conto3 = context.getBean("conto3", ContoCorrente.class);

	        System.out.println("Conto creato come \"@Component\": \n" + contoComponent);
	        System.out.println("*********************************");
	        System.out.println("Bean conto2: \n" + conto2);
	        System.out.println("*********************************");
	        System.out.println("Bean conto3: \n" + conto3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
