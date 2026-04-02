package com.azienda.utilityjdk.esercizio1.ui;

import java.util.Scanner;

public class UIString {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Inserisci una stringa oppure scrivi ESC per uscire: ");
            String s = scanner.nextLine();

            if (s.equalsIgnoreCase("ESC")) {
                System.out.println("Uscita dal programma.");
                break;
            }

            if (s.length() < 8) {
                System.out.println("Errore: la stringa deve avere almeno 8 caratteri. Riprova.");
                continue;
            }

            String sub1 = s.substring(4, 8);
            System.out.println("La sottostringa dal 5 all'8 carattere è: " + sub1);

            String sub2 = s.substring(1, 3).toUpperCase();
            System.out.println("Il 2 ed il 3 carattere, in maiuscolo, sono: " + sub2);

            String sub1Lower = sub1.toLowerCase();
            
            int posizioneR = sub1Lower.indexOf('r');
            if (posizioneR != -1) {
                System.out.println(sub1 + " contiene la r in posizione " + posizioneR);
            }
        }

        scanner.close();
    }
		
}
