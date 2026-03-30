package com.azienda.interfacce.esercizio8.ui;

import java.util.Scanner;

import com.azienda.interfacce.esercizio8.model.Differenza;
import com.azienda.interfacce.esercizio8.model.Divisione;
import com.azienda.interfacce.esercizio8.model.OperazioniAritmetiche;
import com.azienda.interfacce.esercizio8.model.Prodotto;
import com.azienda.interfacce.esercizio8.model.Somma;

public class ChiamanteOperazioni {
	public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        OperazioniAritmetiche obj = null;
        boolean continua = false;
        int a;
        int b;
        int result;

        while (!continua){
            System.out.println("1. Somma | 2. Differenza | 3. Prodotto | 4. Divisione | 0. Esci");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    obj = new Somma();
                    System.out.println("Inserisci il primo numero");
                    a = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserisci il secondo numero");
                    b = scanner.nextInt();
                    scanner.nextLine();
                    result = obj.operate(a, b);
                    obj.printResult(result);
                    break;
                case 2:
                    obj = new Differenza();
                    System.out.println("Inserisci il primo numero");
                    a = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserisci il secondo numero");
                    b = scanner.nextInt();
                    scanner.nextLine();
                    result = obj.operate(a, b);
                    obj.printResult(result);
                    break;
                case 3:
                    obj = new Prodotto();
                    System.out.println("Inserisci il primo numero");
                    a = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserisci il secondo numero");
                    b = scanner.nextInt();
                    scanner.nextLine();
                    result = obj.operate(a, b);
                    obj.printResult(result);
                    break;
                case 4:
                    obj = new Divisione();
                    System.out.println("Inserisci il primo numero");
                    a = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserisci il secondo numero");
                    b = scanner.nextInt();
                    scanner.nextLine();
                    result = obj.operate(a, b);
                    obj.printResult(result);
                    break;
                case 0:
                    System.out.println("Arrivederci");
                    continua = true;
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }
        }
        scanner.close();
    }
}
