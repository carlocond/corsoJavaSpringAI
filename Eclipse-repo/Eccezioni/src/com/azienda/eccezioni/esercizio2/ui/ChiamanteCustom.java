package com.azienda.eccezioni.esercizio2.ui;

import java.util.Scanner;

import com.azienda.eccezioni.esercizio2.model.Controller;
import com.azienda.eccezioni.esercizio2.model.NumeroNegativoException;
import com.azienda.eccezioni.esercizio2.model.NumeroZeroException;

public class ChiamanteCustom {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num1;
        int num2;
        
        while (true) {
            int scelta = leggiNumero(sc, "Procedere con la divisione? 1 = si 2 = no");

            if (scelta == 2) {
                System.out.println("Uscita dal programma.");
                break;
            }

            if (scelta != 1) {
                System.out.println("Scelta non valida. Inserire 1 o 2.");
                continue;
            }
            
            try {
                num1 = leggiNumero(sc, "Inserisci il primo numero: ");
                Controller.checkPositive(num1);
            } 
            catch (NumeroNegativoException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                continue;
            }

            try {
                num2 = leggiNumero(sc, "Inserisci il secondo numero:");
                Controller.checkNotZero(num2);
            } 
            catch (NumeroZeroException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                continue;
            }

            int c = num1 / num2; // divisione intera
            System.out.println(num1 + "/" + num2 + "=" + c);
        }

        sc.close();
    }

    private static int leggiNumero(Scanner scanner, String messaggio) {
        while (true) {
            System.out.println(messaggio);

            try {
            	int n = scanner.nextInt();
            	scanner.nextLine();
            	return n;
            } 
            catch (NumberFormatException e) {
                System.out.println("Numero inserito non valido");
            }
        }

	}

}
