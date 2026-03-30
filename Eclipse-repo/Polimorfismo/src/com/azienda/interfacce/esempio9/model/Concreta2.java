package com.azienda.interfacce.esempio9.model;

public class Concreta2 extends EsempioAstratta{

	@Override
	public void metodoAstratto() {
		System.out.println("Concreta2 - metodoAstratto");
	}

	public void specifico2() {
		System.out.println("Concreta2 - specifico2");
	}
	
	@Override
	public void metodoConcreto() {
		System.out.println("Concreta2 - metodoConcreto");
	}
}
