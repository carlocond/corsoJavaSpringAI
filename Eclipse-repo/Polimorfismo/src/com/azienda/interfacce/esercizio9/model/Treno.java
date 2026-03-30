package com.azienda.interfacce.esercizio9.model;

public class Treno extends VeicoloBase{

    private String localitaPartenza;
    private String localitaArrivo;

    public String getLocalitaPartenza() {
        return localitaPartenza;
    }

    public void setLocalitaPartenza(String localitaPartenza) {
        this.localitaPartenza = localitaPartenza;
    }

    public String getLocalitaArrivo() {
        return localitaArrivo;
    }

    public void setLocalitaArrivo(String localitaArrivo) {
        this.localitaArrivo = localitaArrivo;
    }

    @Override
    public String toString() {
        return "Informazioni Treno:" +
                "\nVelocita' massima: " + super.getVelocitaMax() +
                "\nLocalita' di partenza: " + localitaPartenza +
                "\nLocalita' di arrivo: " + localitaArrivo;
    }
}
