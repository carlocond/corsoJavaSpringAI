package com.azienda.utilityjdk.esercizio4.ui;

import java.util.Scanner;

public class EsercizioArray2 {

	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in)){
			int n;
			
	        while (true) {
	            System.out.print("Inserisci un numero intero positivo: ");
	            n = scanner.nextInt();
	            scanner.nextLine();
	            
	            while (!scanner.hasNextInt()) {
	                System.out.print("Valore non valido. Inserisci un numero intero positivo: ");
	                scanner.next(); // scarta input non numerico
	            }
	            
	            
	            if (n <= 0) {
	            	break;
	            }
  
	        }

	        Integer[][] array = new Integer[n][n];

	        riempiArray(array, true);

	        stampaArray(array);
		} catch(Exception e) {
			
		}
    }

    //Se diagonaleSecondariaInclusa è true, mette 1 anche sulla diagonale secondaria (i + j == n - 1).
	
    public static void riempiArray(Integer[][] array, boolean diagonaleSecondariaInclusa) {
    	int n = array.length;

    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			boolean diagonalePrincipale = (i == j);
    			boolean diagonaleSecondaria = diagonaleSecondariaInclusa && (i + j == n - 1);
                array[i][j] = (diagonalePrincipale || diagonaleSecondaria) ? 1 : 0;
    		}
    	}
    }

    public static void stampaArray(Integer[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
