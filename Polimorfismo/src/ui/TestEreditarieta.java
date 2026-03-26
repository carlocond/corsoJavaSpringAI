package ui;

import models.Figlio;
import models.Padre;

public class TestEreditarieta {
    public static void main(String[] args) {

        Figlio f = new Figlio();
        f.setNomeFiglio("Giovanni");
        f.setNomePadre("Luigi");
        f.setNomeNonno("Luca");

        Padre p = new Padre();
        p.setNomePadre("X");
        p.setNomeNonno("Y");


        System.out.println("Programma terminato");
    }
}
