package com.azienda.eccezioni.esempio3.ui;

import java.util.Scanner;

import com.azienda.eccezioni.esempio3.exception.TooShortStringException;
import com.azienda.eccezioni.esempio3.utils.InputValidator;

public class TestCustomException {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Inserisci la password | Minimo 5 caratteri |");
			String pass = scanner.nextLine();
			InputValidator.check(pass);
			System.out.println("Password valida");
		} 
		catch (TooShortStringException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		catch (Exception e) {
			System.out.println("Qualcosa e' andato storto");
			e.printStackTrace();
		}
	}

}
