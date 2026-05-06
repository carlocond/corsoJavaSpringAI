package com.azienda.esercizio2springboot.config;

import org.springframework.stereotype.Component;

@Component
public class MPTransaction {

	public void begin() {
		System.out.println("Transazione iniziata");
	}
	
	public void commit() {
		System.out.println("Transazione effettuata");
	}
	
	public void rollback(Exception e) {
		System.out.println("Transazione annullata: " + e.getMessage());
	}
}
