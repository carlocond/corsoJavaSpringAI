package com.azienda.eccezioni.esempio1.ui;

import java.util.Scanner;

public class TestException2 {

	public static void main(String[] args) {
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(System.in);
			
		} catch (Exception e) {
			
		}
		finally {
			scanner.close();
		}
	}

}
