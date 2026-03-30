package com.azienda.eccezioni.esempio1.ui;

import java.util.Scanner;

public class TestException3 {

	public static void main(String[] args) {

		//try - with - resources
		//Blocco che usa risorse che implementano l'interfaccia Closeable
		
		try (Scanner scanner = new Scanner(System.in)){
			
		} catch (Exception e) {
			
		}
	}

}
