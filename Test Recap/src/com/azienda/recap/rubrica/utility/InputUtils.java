package com.azienda.recap.rubrica.utility;

import java.util.Scanner;

public class InputUtils {

    public static String leggiStringa(Scanner scanner, String msg) {
        while (true) {
            System.out.println(msg);
            String input = scanner.nextLine();
            if (!input.isEmpty()) return input;
            System.out.println("Errore: non puoi lasciare vuoto!");
        }
    }


}
