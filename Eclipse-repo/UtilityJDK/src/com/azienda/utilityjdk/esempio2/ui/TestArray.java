package com.azienda.utilityjdk.esempio2.ui;

import java.util.Iterator;

import com.azienda.utilityjdk.esempio2.model.Persona;

public class TestArray {

	public static void main(String[] args) {
		
		try {
			int[] numeri = new int[5]; // valore vuoto = 0
			
			Integer[] numeri2 = new Integer[5]; // valore vuoto = null
			
			int[] numeri3 = {1, 3, 4, 6, 12};
			
			System.out.println(numeri[2]);
			numeri[2] = 6;
			
			//Scorrere un array for standard
			for (int i = 0; i < numeri3.length; i++) {
				System.out.println(numeri3[i]);
			}
			
			//Scorrere un array for avanzato
			for (int n : numeri3) {
				System.out.println(n);
			}
			
			String[] nomi = {"Mario", "Claudia", "Laura"};
			
			for (String s : nomi) {
				System.out.println(s);
			}
			
			Persona[] persone = new Persona[3];
			try {
				persone[0].setNome("Mario");
				persone[0].setCognome("");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			persone[0] = new Persona("Mario", "Rossi");
			persone[0].setNome("Giovanni");
			
			Persona[] persone2 = {new Persona("Mario", "Rossi"), 
								  new Persona("Luca", "Neri"), 
								  new Persona("Clauda", "Bianchi")};
			
			for (Persona p : persone2) {
				System.out.println(p);
			}
			persone2[2].setNome("Eva");
			
			System.out.println("Programma terminato");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
