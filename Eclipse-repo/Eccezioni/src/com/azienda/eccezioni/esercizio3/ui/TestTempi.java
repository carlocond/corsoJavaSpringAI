package com.azienda.eccezioni.esercizio3.ui;

import java.util.Scanner;

import com.azienda.eccezioni.esercizio3.exceptions.VeicoloNonValidoException;
import com.azienda.eccezioni.esercizio3.model.Aereo;
import com.azienda.eccezioni.esercizio3.model.CalcolaTempi;
import com.azienda.eccezioni.esercizio3.model.CalcoloTempiAereo;
import com.azienda.eccezioni.esercizio3.model.CalcoloTempiTreno;
import com.azienda.eccezioni.esercizio3.model.Treno;
import com.azienda.eccezioni.esercizio3.model.Veicolo;
import com.azienda.eccezioni.esercizio3.utils.InputUtilities;
import com.azienda.eccezioni.esercizio3.utils.VeicoloFactory;

public class TestTempi {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		VeicoloFactory factory = new VeicoloFactory();
	
		while (true) {
			System.out.println("Inserisci il tipo di veicolo |AEREO o TRENO| \nInserire ESC per uscire");
			String tipo = scanner.nextLine();
		
			if (tipo != null && tipo.trim().equalsIgnoreCase("ESC")) {
				System.out.println("Arrivederci");
				break;
			}
		
			Veicolo veicolo;
			try {
				veicolo = factory.creaVeicolo(tipo, scanner);
			} catch (VeicoloNonValidoException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				continue;
			}
		
			float distanza = InputUtilities.leggiFloat(scanner, "Inserisci la distanza: ");
			
			CalcolaTempi calcolo = scegliCalcolo(veicolo);
			float tempo = calcolo.calcolaTempiPercorrenza(veicolo, distanza);
			
			System.out.println("Veicolo scelto: " + veicolo.getModello() + 
								"\nVelocita': " + veicolo.getVelocita() + 
								"\nDistanza: " + distanza + "km" + 
								"\nTempo medio di percorrenza: " + tempo + "ore");
			
			calcolo.infoMovimento(veicolo);
		}
		
		scanner.close();
	}
	
	private static CalcolaTempi scegliCalcolo(Veicolo v) {
		if (v instanceof Aereo) {
			return new CalcoloTempiAereo();
		} else if (v instanceof Treno) {
        	return new CalcoloTempiTreno();
        } else {
        	return null;
        }
        
	}
} 
