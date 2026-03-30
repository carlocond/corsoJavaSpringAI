package com.azienda.eccezioni.esempio1.ui;

public class TestException {

	public static void main(String[] args) {
	
		try {
			int x = 5;
			int y = 0;
			int z = x / y;
			System.out.println("z = " + z);
		} catch (Exception e) {
			e.printStackTrace();
			int a = 2 / 0;
			System.out.println(a);
		}
		finally {
			System.out.println("Blocco finally");
		}
		
		System.out.println("Programma terminato");
	}

}
