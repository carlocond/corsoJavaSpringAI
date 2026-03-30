package com.azienda.eccezioni.esercizio3.model;

public class Veicolo {

	private String modello;
	private float velocita;
	
	public Veicolo(String modello, Float velocita) {
        this.modello = modello;
        this.velocita = velocita;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public Float getVelocita() {
        return velocita;
    }

    public void setVelocita(Float velocita) {
        this.velocita = velocita;
    }
    
}
