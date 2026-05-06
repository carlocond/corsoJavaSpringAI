package com.azienda.lambda.esempio1.ui;

import com.azienda.lambda.esempio1.model.GestioneOrdini;

public class TestLambda {

	public static void main(String[] args) {
		
		try {
			
			GestioneOrdini ref = (a, b) -> { return a + " " + b; };
			String risultato = ref.creaOrdine("Ordine num:", 112);
			System.out.println(risultato);
			
			System.out.println();
			
			GestioneOrdini ref2 = (a, b) -> { return b + " " + a; };
			risultato = ref2.creaOrdine("Ordine num:", 112);
			System.out.println(risultato);
			
			test(ref);
			
			test((x, y) -> { return x + " " + y * y; } );
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void test(GestioneOrdini go) {
		String result = go.creaOrdine("Fattura numero:", 2);
		System.out.println(result);
	}
}
