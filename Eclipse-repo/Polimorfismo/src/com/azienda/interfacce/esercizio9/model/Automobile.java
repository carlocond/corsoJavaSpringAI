package com.azienda.interfacce.esercizio9.model;

public class Automobile extends VeicoloBase{

    private int cc;

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "Informazioni Auto:" +
                "\nVelocita' massima: " + super.getVelocitaMax() +
                "\nCilindrata: " + cc;
    }
}
