package com.azienda.interfacce.esempio8.model;

public class Implementazione2 implements InterfacciaDefault {

	@Override
	public void astratto() {
		System.out.println("Implementazione2 - metodoAstratto");
	}
	
	@Override
	public void metodoConcreto() {
		System.out.println("Implementazione2 - metodoConcreto");
	}
}
