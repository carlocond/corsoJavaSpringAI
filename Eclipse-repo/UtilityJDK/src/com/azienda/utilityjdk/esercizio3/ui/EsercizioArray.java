package com.azienda.utilityjdk.esercizio3.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EsercizioArray {
	
	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)){
			
			System.out.print("Inserisci la dimensione dell'array: ");
			int dim = acquisizione(scanner);
			
			Integer[] array = new Integer[dim];
			riempiArray(array);
			
			stampaArray(array);
			
			while(true) {
				System.out.print("Cercare un numero nell'array? (s/n): ");
				String choice = scanner.nextLine().trim().toLowerCase();
				
				if (choice.equals("n")) {
					System.out.println("Arrivederci");
					break;
				}
				
				if (!choice.equals("s")) {
					System.out.println("Scelta non valida");
					continue;
				}
				
				System.out.println("Inserisci il numero da cercare: ");
				int num = acquisizione(scanner);
				
				boolean trovato = contiene(array, num);
				if (trovato) {
					System.out.println("Il numero "+ num + " e' stato trovato");
				} else {
					System.out.println("Il numero "+ num + " non e' stato trovato");
				}
			}
			
		} catch (InputMismatchException e) {
			System.out.println("Input non valido");
		} catch (NumberFormatException e) {
			System.out.println("Numero inserito non valido");
		} catch (Exception e) {
			System.out.println("Qualcosa e' andato storto");
		}
	}

	private static Integer acquisizione(Scanner scanner) {
		while(true) {
			
			while(!scanner.hasNextInt()) {
				System.out.println("Valore non valido, numero positivo da inserire");
				scanner.nextLine();
			}
			
			int num = scanner.nextInt();
			
			if(num > 0) {
				return num;
			}
			System.out.println("Il numero deve essere positivo");
		}
	}
	
	private static void riempiArray(Integer[] array) {
		for(int i = 0; i < array.length; i++) {
			array[i] = i * i; //quadrato
		}
	}
	
	private static void stampaArray(Integer[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	private static boolean contiene(Integer[] array, Integer num) {
		for (Integer i : array) {
			if(i != null && i.equals(num)) {
				return true;
			}
		}
		return false;
	}
}
