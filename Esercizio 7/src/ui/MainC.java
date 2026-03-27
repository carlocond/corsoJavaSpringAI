package ui;

import model.ClasseA;
import model.ClasseB;

import java.util.Scanner;

public class MainC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Istanza oggetti ClasseA
        ClasseA a1 = new ClasseA("pippo", 10);
        System.out.println(a1);

        ClasseA a2 = new ClasseA("pippo", 10);
        System.out.println(a1.equals(a2) ? "Sono uguali" : "Sono diversi");

        //Istanza oggetto ClasseB
        ClasseB b1 = new ClasseB("gianni", 12, 3.14f);

        if (b1.getS() == null){
            System.out.println("s del figlio e' null");
        } else {
            System.out.println("s del figlio non e' null, il suo valore e': " + b1.getS());
        }

        System.out.print("Inserisci un valore stringa da inserire su b1: ");
        String stringaNuova = scanner.nextLine();

        b1.setS(stringaNuova);

        System.out.println("Il nuovo valore della stringa b1 e': " + b1.getS());
        System.out.println("Il valore di s del padre e': " + b1.getParentS());
        scanner.close();
    }
}
