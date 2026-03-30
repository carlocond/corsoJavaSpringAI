package com.azienda.interfacce.esempio8.ui;

import com.azienda.interfacce.esempio8.model.Implementazione1;
import com.azienda.interfacce.esempio8.model.InterfacciaDefault;

public class TestDefault {

	public static void main(String[] args) {
		
		InterfacciaDefault ref = new Implementazione1();
		
		ref.astratto();
		ref.metodoConcreto();
		InterfacciaDefault.metodoStatico();
		System.out.println("Programma terminato");

	}

}
