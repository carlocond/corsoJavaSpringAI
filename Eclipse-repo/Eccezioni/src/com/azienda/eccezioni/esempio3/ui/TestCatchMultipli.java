package com.azienda.eccezioni.esempio3.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestCatchMultipli {

	public static void main(String[] args) {
		
		
		try (Scanner scanner = new Scanner(System.in)){
			System.out.println("Inserisci un numero: ");
			int num = scanner.nextInt();
			scanner.nextLine();
			int risultato = 10 / num;
			System.out.println(risultato);
		} 
		catch (InputMismatchException e) {
			System.out.println("Devi inserire un numero");
			e.printStackTrace();
		}
		catch (ArithmeticException e) {
			System.out.println("Non puoi dividere per 0");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Errore imprevisto");
			e.printStackTrace();
		}
	}
}
