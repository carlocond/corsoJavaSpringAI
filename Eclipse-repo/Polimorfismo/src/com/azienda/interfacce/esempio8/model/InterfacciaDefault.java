package com.azienda.interfacce.esempio8.model;

public interface InterfacciaDefault {
	
	public void astratto();
	
	public default void metodoConcreto() {
		System.out.println("Implementazione di default metodo concreto");
	}
	
	public static void metodoStatico() {
		System.out.println("Metodo statico");
	}

}
