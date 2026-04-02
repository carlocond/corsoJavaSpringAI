package com.azienda.utilityjdk.esempio5.model;

public class Automobile implements Comparable<Automobile>{

	private String modello;
	private float cc;
	
	public Automobile(String modello, float cc) {
		super();
		this.modello = modello;
		this.cc = cc;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public float getCc() {
		return cc;
	}

	public void setCc(float cc) {
		this.cc = cc;
	}

	@Override
	public String toString() {
		return "Automobile [modello=" + modello + ", cc=" + cc + "]";
	}

	@Override
	public int compareTo(Automobile o) {
		//Confronto su modello
		return modello.compareTo(o.getModello());
	}
	
	
}
