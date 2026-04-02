package com.azienda.utilityjdk.esempio1.ui;

public class TestInteger {

	public static void main(String[] args) {
		
		int numeroPrimitivo = 10;
		
		Integer numeroReference = numeroPrimitivo; //Autoboxing
		numeroReference = 11;
		
		Integer numeroReference2 = 10;
		
		//Autounboxing
		numeroPrimitivo = numeroReference; // prende il valore dell'oggetto con il metodo get di Integer, .intValue()
		
		System.out.println("Programma terminato");
		
		test(numeroPrimitivo);
		test2(numeroReference);

	}
	
	private static void test(Integer x) {
		System.out.println(x);
	}
	
	private static void test2(int x) {
		System.out.println(x);
	}

}
