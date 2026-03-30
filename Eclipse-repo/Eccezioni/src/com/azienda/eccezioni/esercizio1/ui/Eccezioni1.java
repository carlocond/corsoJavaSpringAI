package com.azienda.eccezioni.esercizio1.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Eccezioni1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int num1;
		int num2;
		
		try {
			while(true) {
				try {
					System.out.print("Inserisci il primo numero: ");
					num1 = scanner.nextInt();
					scanner.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Devi inserire un numero");
					scanner.nextLine();
				}
			}
			if (num1 < 0) {
				throw new RuntimeException("Numero inferiore a 0 non valido");
			}
		} catch (RuntimeException e) {
			System.out.println("E' successo qualcosa");
			scanner.close();
			return;
		}
		
		try {
			while(true) {
				try {
					System.out.print("Inserisci il secondo numero: ");
					num2 = scanner.nextInt();
					scanner.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Devi inserire un numero");
					scanner.nextLine();
				}
			}
			if(num2 == 0) {
				throw new RuntimeException("Divisore uguale a 0 non valido");
			}
		} catch (RuntimeException e) {
			System.out.println("E' successo qualcosa");
			scanner.close();
			return;
		}
		
		double res = (double) num1 / num2;
		System.out.println("Divisione: " + num1 + "/" + num2 + " = " + res);
		scanner.close();
	}
}
