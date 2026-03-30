package com.azienda.eccezioni.esercizio2.model;

public class Controller {

    public static void checkPositive(int num) throws NumeroNegativoException {
        if (num < 0) {
            throw new NumeroNegativoException("Il numero inserito non deve essere negativo.", null);
        }
    }

    public static void checkNotZero(int num) {
        if (num == 0) {
            throw new NumeroZeroException("Il divisore non può essere 0.", null);
        }
    }
}
