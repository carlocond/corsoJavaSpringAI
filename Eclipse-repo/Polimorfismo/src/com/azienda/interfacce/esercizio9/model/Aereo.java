package com.azienda.interfacce.esercizio9.model;

public class Aereo extends VeicoloBase{

    private boolean diLinea;

    public boolean getDiLinea() {
        return diLinea;
    }

    public void setDiLinea(boolean diLinea) {
        this.diLinea = diLinea;
    }

    @Override
    public String toString() {
        return "Informazioni Aereo:" +
                "\nVelocita' massima: " + super.getVelocitaMax() +
                "\nE' di linea: " + diLinea;
    }
}
