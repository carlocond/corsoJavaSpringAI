package ui;

import model.Bottiglia;
import utility.Constants;

public class UsoBottiglia {
    public static void main(String[] args) {

        Bottiglia b1 = new Bottiglia(Constants.CONTENUTO_ACQUA, Constants.MATERIALE_PLASTICA, 2, 0);

        if (b1.aggiungi(10)){
            System.out.println("10 litri entrano nella bottiglia");
        } else {
            System.out.println("10 litri non entrano nella bottiglia");
        }

        System.out.println(b1.stampaBottiglia());

        System.out.println("**********************************");

        if (b1.aggiungi(1)){
            System.out.println("1 litro entra nella bottiglia");
        } else {
            System.out.println("1 litro non entra nella bottiglia");
        }

        System.out.println(b1.stampaBottiglia());

        System.out.println("**********************************");

        Bottiglia b2 = new Bottiglia(Constants.CONTENUTO_VINO, Constants.MATERIALE_VETRO, 1.33, 0);

        if (b2.aggiungi(10)){
            System.out.println("10 litri entrano nella bottiglia");
        } else {
            System.out.println("10 litri non entrano nella bottiglia");
        }

        System.out.println(b2.stampaBottiglia());

        System.out.println("**********************************");

        if (b2.aggiungi(1)){
            System.out.println("1 litro entra nella bottiglia");
        } else {
            System.out.println("1 litro non entra nella bottiglia");
        }

        System.out.println(b2.stampaBottiglia());

    }
}
