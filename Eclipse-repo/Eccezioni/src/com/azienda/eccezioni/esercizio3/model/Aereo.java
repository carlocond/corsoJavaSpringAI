package com.azienda.eccezioni.esercizio3.model;

public class Aereo extends Veicolo {

	private Boolean diLinea;

    public Aereo(String modello, Float velocita, Boolean diLinea) {
        super(modello, velocita);
        this.diLinea = diLinea;
    }

    public Boolean getDiLinea() {
        return diLinea;
    }

    public void setDiLinea(Boolean diLinea) {
        this.diLinea = diLinea;
    }

    public void vola() {
        System.out.println("L'aereo sta volando verso la destinazione.");
    }
}
