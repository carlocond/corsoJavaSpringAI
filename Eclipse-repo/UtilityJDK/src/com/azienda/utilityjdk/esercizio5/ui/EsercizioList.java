package com.azienda.utilityjdk.esercizio5.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EsercizioList {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)){
			
			List<String> lista = new ArrayList<>();
			
			//Primo ciclo
			while (true) {
				System.out.print("Inserisci una stringa oppure ESC per uscire: ");
				String input = scanner.nextLine();
				
				if (input.equalsIgnoreCase("ESC")) {
					System.out.println("Arrivederci");
					break;
				}
				
				lista.add(input);
			}
			
			//Utilizzo metodi
			System.out.println("Stampa con for classico");
			printList(lista);
			
			System.out.println("Stampa con foreach");
			printList2(lista);
			
			System.out.println("Stampa con Iterator");
			printList3(lista);
			
			//Secondo ciclo
			while (true) {
				System.out.println("Inserisci una stringa da cercare oppure ESC per uscire");
				String input2 = scanner.nextLine();
				
				if (input2.equalsIgnoreCase("ESC")) {
					System.out.println("Arrivederci");
					break;
				}
				
				List<String> result = cercaString(lista, input2);
				
				if (result.isEmpty()) {
					System.out.println("Nessun risultato");
				} else {
					System.out.println("Trovati " + result.size() + " elementi");
					for (String r : result) {
						System.out.println(r);
					}
				}
			}
			
			System.out.println("Programma terminato");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void printList(List<String> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println("Elemento in posizione " + i +": " + list.get(i));
		}
	}
	
	private static void printList2(List<String> list) {
		for(String s : list) {
			System.out.println(s);
		}
	}
	
	private static void printList3(List<String> list) {
		Iterator<String> iteratore = list.iterator();
		while (iteratore.hasNext()) {
			System.out.println(iteratore.next());
		}
	}
	
	//Metodo sviluppato per agevolare la ricerca nella lista di una specifica stringa.
	private static List<String> cercaString(List<String> list, String input){
		List<String> result = new ArrayList<>();
		
		String stringa = input.toLowerCase();
		
		 for (String s : list){
			 if (s != null && s.toLowerCase().contains(stringa)) {
				result.add(s);
			}
		 }
		 return result;
	}

}
