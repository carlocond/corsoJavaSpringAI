package ui;

import model.Automobile;
import model.Persona;

public class TestOverrideEquals {
    public static void main(String[] args) {

        Persona p1 = new Persona("Mario", "Rossi", "RSIMRO123D34H456X");
        Persona p2 = new Persona("Mario", "Rossi", "RSIMRO123D34H456X");

        Automobile a1 = new Automobile("BMW", 2023, 4573, p1);
        Automobile a2 = new Automobile("BMW", 2023, 4573, p2);
        confronto(a1, a2);

        String s1 = "ciao";
        //s1 = "ciao2";

        String s2 = "ciao";
        String s3 = new String("ciao");
        String s4 = new String("ciao");

        System.out.println("Programma terminato");


    }

    public static void confronto(Automobile a1, Automobile a2){
        if (a1 == a2){
            System.out.println("Le due auto sono uguali con ==");
        } else {
            System.out.println("Le due auto non sono uguali con ==");
        }

        if (a1.equals(a2)){
            System.out.println("Le due auto sono uguali con equals");
        } else {
            System.out.println("Le due auto non sono uguali con equals");
        }
    }
}
