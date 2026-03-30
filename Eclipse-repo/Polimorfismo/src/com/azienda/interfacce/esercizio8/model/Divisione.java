package com.azienda.interfacce.esercizio8.model;

public class Divisione extends AbstractOperazioni{

    @Override
    public int operate(int a, int b) {
        if (b == 0){
            return 0;
        }
        return a / b;
    }

    @Override
    String getOperazione() {
        return "divisione";
    }
}
