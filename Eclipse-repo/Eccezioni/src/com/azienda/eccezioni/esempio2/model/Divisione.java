package com.azienda.eccezioni.esempio2.model;

public class Divisione {

	public static int divisioneChecked(int x, int y) throws Exception {
		if (y == 0) {
			throw new Exception("Il divisore non puo' essere 0");
		}
		return x / y;
	}
	
	public static int divisioneUnchecked(int x, int y) {
		if (y == 0) {
			throw new RuntimeException("Il divisore non puo' essere 0");
		}
		return x / y;
	}
	
	public static int divisione3(int x, int y) throws Exception{
		try {
			return x / y;
		} catch (Exception e) {
			System.out.println("Catturata eccezione: " + e.getMessage());
			throw new Exception("Divisore errato", e);
		}
	}
}
