package ui;

import model.ContoCorrente;
import model.Indirizzo;
import model.Banca;

import java.util.Scanner;

public class UsoContoCorrente {
    public static void main(String[] args){

        Indirizzo indirizzo = new Indirizzo("Roma", "Via Roma", 10);
        System.out.println(indirizzo.descrizione());

        System.out.println("**********************");

        Banca banca = new Banca("Banca di Roma", indirizzo);
        System.out.println(banca.descrizione());

        System.out.println("**********************");

        ContoCorrente conto1 = new ContoCorrente("123456789", 1000f, banca);
        ContoCorrente conto2 = new ContoCorrente("987654321", 500f, null);

        System.out.println(conto1.getCittaBanca());
        System.out.println("**********************");
        System.out.println(conto2.getCittaBanca());

        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci l'importo da trasferire: ");
        float importo = scanner.nextFloat();
        scanner.nextLine();

        if (conto2.getSaldo() - importo >= 0) {
            conto1.setSaldo(conto1.getSaldo() + importo);
            conto2.setSaldo(conto2.getSaldo() - importo);

            System.out.println("Ecco i dettagli del nuovo stato del primo conto: ");
            System.out.println(conto1.descrizione());
            System.out.println("**********************");
            System.out.println("Ecco i dettagli del nuovo stato del secondo conto: ");
            System.out.println(conto2.descrizione());
        } else {
            System.out.println("Insufficient balance in the second account.");
        }
        scanner.close();
    }
}
