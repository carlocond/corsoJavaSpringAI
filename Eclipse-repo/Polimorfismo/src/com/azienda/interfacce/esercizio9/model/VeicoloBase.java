package com.azienda.interfacce.esercizio9.model;

public class VeicoloBase implements Veicolo {

    private float velocitaMax;

    @Override
    public float getVelocitaMax() {
        return velocitaMax;
    }

    @Override
    public void setVelocitaMax(float velocitaMax) {
        this.velocitaMax = velocitaMax;
    }
    
}
