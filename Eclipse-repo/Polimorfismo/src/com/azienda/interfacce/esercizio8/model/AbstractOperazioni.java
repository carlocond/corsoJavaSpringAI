package com.azienda.interfacce.esercizio8.model;

public abstract class AbstractOperazioni implements OperazioniAritmetiche{

    abstract String getOperazione();

    @Override
    public void printResult(int result) {
        System.out.println("Il risultato  del/della " + getOperazione() + " e': " + result);
    }
}
