package com.azienda.eccezioni.esercizio3.model;

public class Treno extends Veicolo {
    private Boolean regionale;

    public Treno(String modello, Float velocita, Boolean regionale) {
        super(modello, velocita);
        this.regionale = regionale;
    }

    public Boolean getRegionale() {
        return regionale;
    }

    public void setRegionale(Boolean regionale) {
        this.regionale = regionale;
    }

    public void percorreBinari() {
        System.out.println("Il treno sta percorrendo i binari.");
    }
}
