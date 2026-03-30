package com.azienda.interfacce.esercizio9.model;

public class Nave extends VeicoloBase{

    private int numeroCabine;

    public int getNumeroCabine() {
        return numeroCabine;
    }

    public void setNumeroCabine(int numeroCabine) {
        this.numeroCabine = numeroCabine;
    }

    @Override
    public String toString() {
        return  "Informazioni Nave:" +
                "\nVelocita' massima: " + super.getVelocitaMax() +
                "\nNumero Cabine: " + numeroCabine;
    }
}
