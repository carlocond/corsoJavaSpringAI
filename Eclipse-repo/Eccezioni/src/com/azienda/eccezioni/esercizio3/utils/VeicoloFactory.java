package com.azienda.eccezioni.esercizio3.utils;

import java.util.Scanner;

import com.azienda.eccezioni.esercizio3.exceptions.VeicoloNonValidoException;
import com.azienda.eccezioni.esercizio3.model.Aereo;
import com.azienda.eccezioni.esercizio3.model.Treno;
import com.azienda.eccezioni.esercizio3.model.Veicolo;

public class VeicoloFactory {

	public Veicolo creaVeicolo(String tipo, Scanner sc) throws VeicoloNonValidoException {
        Validatore.valida(tipo);

        String t = tipo.trim().toLowerCase();

        String modello = InputUtilities.leggiString(sc, "Inserisci il modello del veicolo:");
        float velocita = InputUtilities.leggiFloat(sc, "Inserisci la velocità media (km/h):");

        if (Validatore.AEREO.equals(t)) {
            boolean diLinea = InputUtilities.leggiBoolean(sc, "L'aereo è di linea?");
            return new Aereo(modello, velocita, diLinea);
        }

        // Validatore.TRENO
        boolean regionale = InputUtilities.leggiBoolean(sc, "Il treno è regionale?");
        return new Treno(modello, velocita, regionale);
	}
}
