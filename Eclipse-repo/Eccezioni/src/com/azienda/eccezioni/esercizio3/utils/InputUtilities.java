package com.azienda.eccezioni.esercizio3.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class InputUtilities {

	private InputUtilities() { }
	
	public static boolean leggiBoolean(Scanner scanner, String msg) {
		while (true) {
			System.out.println(msg + " true/false");
			try {
				boolean in = scanner.nextBoolean();
				scanner.nextLine();
				return in;
			} catch (InputMismatchException e) {
				System.out.println("Valore non valido");
			}
		}
	}
	
	public static float leggiFloat(Scanner scanner, String msg) {
		while (true) {
			System.out.println(msg + " inserire un numero");
			try {
				float in = scanner.nextFloat();
				scanner.nextLine();
				return in;
			} catch (InputMismatchException e) {
				System.out.println("Valore non valido");
			}
		}
	}
	
	public static String leggiString(Scanner scanner, String msg) {
		while(true) {
			System.out.println(msg + " inserire una stringa");
			String s = scanner.nextLine();
			if (s != null && !s.trim().isEmpty()) {
				return s.trim();
			}
			System.out.println("Valore non valido");
		}
	}
	
}
