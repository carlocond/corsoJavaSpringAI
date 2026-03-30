package com.azienda.interfacce.esempio9.model;

public class Concreta1 extends EsempioAstratta {

	@Override
	public void metodoAstratto() {
		System.out.println("Concreta1 - metodoAstratto");
	}
	
	public void specifico1() {
		System.out.println("Concreta1 - specifico1");
	}

}
