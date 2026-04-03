package com.azienda.recap.rubrica.ui;

import com.azienda.recap.rubrica.exceptions.ContattoGiaPresenteException;
import com.azienda.recap.rubrica.exceptions.ContattoNonPresente;
import com.azienda.recap.rubrica.model.Contatto;
import com.azienda.recap.rubrica.model.Rubrica;
import com.azienda.recap.rubrica.service.ServiceRubrica;
import com.azienda.recap.rubrica.utility.InputUtils;

import java.util.List;
import java.util.Scanner;

public class TestRecap {
    public static void main(String[] args) {

        Rubrica rubrica = new Rubrica("Rubrica Personale", 2026);
        ServiceRubrica serviceRubrica = new ServiceRubrica(rubrica);

        String nome, cognome, numero;
        List<Contatto> risultati;

        boolean continua = false;

        try (Scanner scanner = new Scanner(System.in)) {
            while (!continua) {
                stampaMenu();
                System.out.print("Scelta: ");
                String scelta = scanner.nextLine().trim();

                try {
                    switch (scelta) {
                        case "1" :
                            nome = InputUtils.leggiStringa(scanner, "Inserisci nome:");
                            cognome = InputUtils.leggiStringa(scanner, "Inserisci cognome:");
                            numero = InputUtils.leggiStringa(scanner, "Inserisci numero di telefono:");

                            serviceRubrica.creaContatto(new Contatto(nome, cognome, numero));
                            System.out.println("Contatto creato con successo.");
                            break;

                        case "2":
                            nome = InputUtils.leggiStringa(scanner, "Nome del contatto da cercare:");
                            cognome = InputUtils.leggiStringa(scanner, "Cognome del contatto da cercare:");

                            Contatto trovato = serviceRubrica.trovaContatto(nome, cognome);
                            stampaContatto(trovato);
                            break;

                        case "3":
                            nome = InputUtils.leggiStringa(scanner, "Nome del contatto da aggiornare:");
                            cognome = InputUtils.leggiStringa(scanner, "Cognome del contatto da aggiornare:");

                            System.out.print("Nuovo nome (invio per non modificare): ");
                            String nomeNuovo = scanner.nextLine();

                            System.out.print("Nuovo cognome (invio per non modificare): ");
                            String cognomeNuovo = scanner.nextLine();

                            System.out.print("Nuovo telefono (invio per non modificare): ");
                            String telNuovo = scanner.nextLine();

                            serviceRubrica.aggiornaContatto(nome, cognome, nomeNuovo, cognomeNuovo, telNuovo);
                            System.out.println("Contatto aggiornato con successo.");
                            break;

                        case "4":
                            nome = InputUtils.leggiStringa(scanner, "Nome del contatto da cancellare:");
                            cognome = InputUtils.leggiStringa(scanner, "Cognome del contatto da cancellare:");

                            serviceRubrica.cancellaContatto(nome, cognome);
                            System.out.println("Contatto cancellato con successo.");
                            break;

                        case "5":
                            nome = InputUtils.leggiStringa(scanner, "Inserisci parte del nome da cercare:")
                                    .toLowerCase();
                            risultati = serviceRubrica.cercaPerNome(nome);
                            stampaListaContatti(risultati);
                            break;

                        case "6":
                            cognome = InputUtils.leggiStringa(scanner, "Inserisci parte del cognome da cercare:")
                                    .toLowerCase();
                            risultati = serviceRubrica.cercaPerCognome(cognome);
                            stampaListaContatti(risultati);
                            break;

                        case "7":
                            numero = InputUtils.leggiStringa(scanner, "Inserisci parte del numero da cercare:")
                                    .toLowerCase();
                            risultati = serviceRubrica.cercaPerNumeroTelefono(numero);
                            stampaListaContatti(risultati);
                            break;

                        case "8":
                            System.out.println("====== LISTA CONTATTI ======");
                            stampaListaContatti(rubrica.getContatti());
                            break;

                        case "9":
                            System.out.println("====== LISTA CONTATTI ORDINATI PER INSERIMENTO ======");
                            stampaListaContatti(serviceRubrica.ordinePerInserimento());
                            break;

                        case "10":
                            System.out.println("====== LISTA CONTATTI ORDINATI PER NOME ======");
                            stampaListaContatti(serviceRubrica.ordinePerNome());
                            break;

                        case "11":
                            System.out.println("====== LISTA CONTATTI ORDINATI PER COGNOME ======");
                            stampaListaContatti(serviceRubrica.ordinePerCognome());
                            break;

                        case "12":
                            System.out.println("====== LISTA CONTATTI ORDINATI CON PRIORITA' COGNOME ======");
                            stampaListaContatti(serviceRubrica.ordinePerCognomeNome());
                            break;

                        case "0":
                            System.out.println("Arrivederci");
                            continua = true;
                            break;
                        default:
                            System.out.println("Scelta non valida.");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Errore inatteso: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    private static void stampaMenu() {
        System.out.println("====== MENU RUBRICA ======");
        System.out.println("1  - Crea contatto");
        System.out.println("2  - Trova contatto (nome + cognome)");
        System.out.println("3  - Aggiorna contatto");
        System.out.println("4  - Cancella contatto");
        System.out.println("5  - Cerca per nome");
        System.out.println("6  - Cerca per cognome");
        System.out.println("7  - Cerca per numero telefono");
        System.out.println("8  - Visualizza tutti i contatti");
        System.out.println("9  - Visualizza per ordine di inserimento");
        System.out.println("10  - Visualizza ordinati per nome");
        System.out.println("11 - Visualizza ordinati per cognome");
        System.out.println("12 - Visualizza ordinati per cognome + nome");
        System.out.println("0  - Esci");
        System.out.println("==========================");
    }

    private static void stampaContatto(Contatto contatto) {
        System.out.println(contatto);
    }

    private static void stampaListaContatti(List<Contatto> contatti) {
        if (contatti == null || contatti.isEmpty()) {
            System.out.println("Nessun contatto trovato.");
            return;
        }
        for (Contatto c : contatti) {
            System.out.println(c);
            System.out.println("--------------------------");
        }
    }
}
