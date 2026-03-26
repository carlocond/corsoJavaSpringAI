package ui;

import model.Lavoratore;
import model.Studente;

import java.util.Scanner;

public class TestStudenteLavoratore {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Studente s;
        Lavoratore l;
        String nome;
        String cognome;
        boolean continua = false;



        while (!continua){
            System.out.println("1. Crea Studente | 2. Crea Lavoratore | 0. Esci");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Inserisci il nome: ");
                    nome = scanner.nextLine();
                    System.out.println("Inserisci il cognome: ");
                    cognome = scanner.nextLine();
                    System.out.println("Inserisci la media dei voti");
                    double mediaVoti = scanner.nextDouble();

                    if (mediaVoti > 0 && mediaVoti <= 10) {
                        s = new Studente(nome, cognome, mediaVoti);
                        System.out.println("Studente creato con successo!");
                        System.out.println(s.infoStudente());
                    } else {
                        System.out.println("Studente con media non valida, creazione non riuscita");
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Inserisci il nome: ");
                    nome = scanner.nextLine();
                    System.out.println("Inserisci il cognome: ");
                    cognome = scanner.nextLine();
                    System.out.println("Inserisci lo stipendio: ");
                    double stipendio = scanner.nextDouble();
                    if (stipendio > 0) {
                        l = new Lavoratore(nome, cognome, stipendio);
                        System.out.println("Lavoratore creato con successo!");
                        System.out.println(l.infoLavoratore());
                    } else {
                        System.out.println("Lavoratore con Stipendio non valido, creazione non riuscita");
                        break;
                    }
                case 0:
                    System.out.println("Arrivederci");
                    continua = true;
                    break;
                default:
                    System.out.println("Qualcosa e' andato storto");
                    break;
            }
        }
        scanner.close();
    }
}
