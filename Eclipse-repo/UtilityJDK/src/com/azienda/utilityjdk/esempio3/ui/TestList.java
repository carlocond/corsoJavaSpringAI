package com.azienda.utilityjdk.esempio3.ui;

import java.util.List;

import com.azienda.utilityjdk.esempio2.model.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class TestList {

	public static void main(String[] args) {
		
		try {
			
			List<String> nomi = new ArrayList<>();
			System.out.println("Dimensione attuale lista: " + nomi.size() + " elementi presenti");
			nomi.add("Mario");
			nomi.add("Laura");
			nomi.add("Claudia");
			
			nomi.add(1, "Luigi");
			nomi.add("Mario");
			
			String s = nomi.get(3);
			System.out.println(s);
			try {
				
				s = nomi.get(6);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			boolean b1 = nomi.contains("Laura");
			boolean b2 = nomi.contains("laura");
			nomi.remove("luigi");
			nomi.remove("Luigi");
			
			for (int i = 0; i < nomi.size(); i++) {
				System.out.println(nomi.get(i));
			}
			
			List<Persona> persone = new ArrayList<>();
			persone.add(new Persona("Mario", "Rossi"));
			persone.add(new Persona("Laura", "Verdi"));
			persone.add(new Persona("Claudia", "Bianchi"));
			
			b1 = persone.contains(new Persona("Laura", "Verdi"));
			
			for (Persona p : persone) {
				System.out.println(p);
			}
			
			List<Integer> numeri = Arrays.asList(2, 3, 4, 6);
			List<Persona> persone2 = Arrays.asList(new Persona("Pippo", "Pappo"), new Persona("Ciccio", "Ciccia"));
			
			Iterator<Integer> iteratorNumeri = numeri.iterator();
			
			while (iteratorNumeri.hasNext()) {
				Integer numero = iteratorNumeri.next();
				System.out.println(numero);
			}
			
			Iterator<Persona> iteratorPersone = persone2.iterator();
			
			while (iteratorPersone.hasNext()) {
				Persona px = iteratorPersone.next();
				System.out.println(px);
			}
			
			System.out.println("Programma terminato");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
