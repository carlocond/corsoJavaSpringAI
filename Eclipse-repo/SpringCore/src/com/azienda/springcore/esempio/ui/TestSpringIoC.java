package com.azienda.springcore.esempio.ui;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.azienda.springcore.esempio.config.SpringConfiguration;
import com.azienda.springcore.esempio.model.Stanza;
import com.azienda.springcore.esempio.model.Tavolo;

public class TestSpringIoC {

	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class)){
			Stanza s = context.getBean("stanza", Stanza.class);
			Tavolo t = context.getBean("tavolo", Tavolo.class);
			System.out.println(s);
			System.out.println(t);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
