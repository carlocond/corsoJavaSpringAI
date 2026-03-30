package com.azienda.interfacce.esercizio8.model;

public class Differenza extends AbstractOperazioni{
    @Override
    public int operate(int a, int b) {
        return a - b;
    }

    @Override
    String getOperazione() {
        return "differenza";
    }
}
