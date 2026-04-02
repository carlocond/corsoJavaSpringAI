package com.azienda.utilityjdk.esempio5.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestMap {

	public static void main(String[] args) {
		
		try {
			
			Map<Integer, String> mappa = new HashMap<>();
			mappa.put(-16, "Mario");
			mappa.put(-16, "Luigi");//sovrascrittura della precedente
			mappa.put(13, "Laura");
			mappa.put(-150, "Claudia");
			mappa.put(7, "Paolo");
			System.out.println(mappa.size()); //quanti elementi sono presenti
			//mappa.clear(); //ripulisce tutta la mappa
			//mappa.containsKey(); //Controlla se esiste un elemento in base ad una chiave
			//mappa.containsValue(); //Controlla se esiste un elemento in base ad un valore
			String nome = mappa.get(-16); //Assegna il valore in base alla chiave
			nome = mappa.get(16); //Assegna il valore in base ad una chiave che non esiste, esce null
			
			Set<Integer> chiavi = mappa.keySet(); //Creo un set con le chiavi della mappa
			
			for (Integer chiave : chiavi) {
				String valore = mappa.get(chiave);
				System.out.println("Valore: " + valore + " | Chiave: " + chiave);
			}
			
			Set<Entry<Integer, String>> setCoppie = mappa.entrySet();
			
			for (Entry<Integer, String> coppia : setCoppie) {
				System.out.println("Chiave coppia: " + coppia.getKey() + " | Valore coppia: " + coppia.getValue());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
