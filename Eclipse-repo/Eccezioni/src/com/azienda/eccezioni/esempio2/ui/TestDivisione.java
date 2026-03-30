package com.azienda.eccezioni.esempio2.ui;

import com.azienda.eccezioni.esempio2.model.Divisione;

public class TestDivisione {

	public static void main(String[] args) {

		try {
			int risultato = Divisione.divisioneChecked(4, 2);
			System.out.println(risultato);
			
			try {
				int risultato2 = Divisione.divisioneUnchecked(3, 0);
				System.out.println(risultato2);
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			try {
				int risultato3 = Divisione.divisione3(10, 0);
				System.out.println(risultato3);
			} 
			
			catch (Exception e) {
				System.out.println(e.getMessage());
				Throwable causa = e.getCause();
				e.printStackTrace();
			}
			System.out.println("Fine del try");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
