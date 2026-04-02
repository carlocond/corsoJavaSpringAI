package com.azienda.utilityjdk.esempio5.ui;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.azienda.utilityjdk.esempio5.model.Automobile;
import com.azienda.utilityjdk.esempio5.utils.AutomobileComparatorByCc;
import com.azienda.utilityjdk.esempio5.utils.AutomobileComparatorByModelloAndCc;

public class TestOrdinamento {

	public static void main(String[] args) {
		
		try {
			
			List<String> nomi = Arrays.asList("Mario", "Claudia", "Stefania", "Andrea");
			Collections.sort(nomi);
			stampaLista(nomi);
			
			System.out.println("***********");
			
			Collections.reverse(nomi);
			stampaLista(nomi);
			
			System.out.println("***********");
			
			List<Automobile> listaAuto = Arrays.asList(new Automobile("B", 2000f), 
														new Automobile("A", 2500f), 
														new Automobile("C", 1000f),
														new Automobile("B", 3000f));
			
			Collections.sort(listaAuto);
			stampaListaAuto(listaAuto);
			
			System.out.println("***********");
			
			Collections.sort(listaAuto, new AutomobileComparatorByCc());
			stampaListaAuto(listaAuto);
			
			System.out.println("***********");
			
			Collections.sort(listaAuto, new AutomobileComparatorByModelloAndCc());
			stampaListaAuto(listaAuto);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void stampaLista(List<String> list) {
		for (String s : list) {
			System.out.println(s);
		}
	}
	
	private static void stampaListaAuto(List<Automobile> list) {
		 for (Automobile a : list){
			 System.out.println(a);
		 }
	}

}
