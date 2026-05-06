package com.azienda.jdbcEsercizio2.exec;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.azienda.jdbcEsercizio2.businessLogic.AutomobileService;
import com.azienda.jdbcEsercizio2.dao.DBConnection;
import com.azienda.jdbcEsercizio2.dao.DaoAutomobile;
import com.azienda.jdbcEsercizio2.model.Automobile;

public class TestEsercizioJDBC {

    public static void main(String[] args) {

        try (Connection con = DBConnection.getConnection();
             Scanner sc = new Scanner(System.in)) {

            DaoAutomobile daoAutomobile = new DaoAutomobile(con);
            AutomobileService service = new AutomobileService(daoAutomobile);

            boolean continua = true;

            while (continua) {
                System.out.println("\n===== MENU ESERCIZIO JDBC =====");
                System.out.println("1) Inserisci automobile");
                System.out.println("2) Cancella automobili per prefisso marca");
                System.out.println("3) Aggiorna targa per prefisso marca");
                System.out.println("4) Mostra tutte le automobili");
                System.out.println("5) Aggiorna automobile per ID");
                System.out.println("6) Cancella automobile per ID");
                System.out.println("0) Esci");
                System.out.print("Scelta: ");

                int scelta;
                if (sc.hasNextInt()) {
                    scelta = sc.nextInt();
                    sc.nextLine();
                } else {
                    System.out.println("Scelta non valida: inserisci un numero.");
                    sc.nextLine();
                    continue;
                }

                try {
                    switch (scelta) {
                        case 1: {
                        	System.out.println("CREAZIONE AUTOMOBILE, COMPLETA TUTTI I CAMPI");
                        	System.out.println();
                            System.out.print("Inserisci la marca: ");
                            String marca = sc.nextLine();
                            System.out.print("Inserisci il modello: ");
                            String modello = sc.nextLine();
                            System.out.print("Inserisci la targa: ");
                            String targa = sc.nextLine();
                            System.out.print("Inserisci il colore: ");
                            String colore = sc.nextLine();
                            System.out.print("Inserisci la cilindrata: ");
                            Float cilindrata = Float.parseFloat(sc.nextLine());

                            Automobile inserita = service.addAutomobile(marca, modello, targa, colore, cilindrata);
                            System.out.println("Inserita con successo:");
                            System.out.println(inserita);
                            break;
                        }

                        case 2: {
                            System.out.print("Inserisci prefisso marca: ");
                            String prefisso = sc.nextLine();
                            service.deleteByMarca(prefisso);
                            System.out.println("Cancellazione completata.");
                            break;
                        }

                        case 3: {
                            System.out.print("Inserisci prefisso marca: ");
                            String prefisso = sc.nextLine();
                            System.out.print("Inserisci nuova targa: ");
                            String nuovaTarga = sc.nextLine();
                            service.updateTargaByMarca(prefisso, nuovaTarga);
                            System.out.println("Aggiornamento targa completato.");
                            break;
                        }

                        case 4: {
                            List<Automobile> lista = service.getAllAutomobile();
                            if (lista.isEmpty()) {
                                System.out.println("Nessuna automobile trovata.");
                            } else {
                                System.out.println("\n--- Elenco automobili ---");
                                for (Automobile a : lista) {
                                    System.out.println(a);
                                    System.out.println("-------------------------");
                                }
                            }
                            break;
                        }

                        case 5: {
                            System.out.print("Inserisci l'ID da aggiornare: ");
                            Integer id = Integer.parseInt(sc.nextLine());
                            System.out.print("Inserisci la nuova marca: ");
                            String marca = sc.nextLine();
                            System.out.print("Inserisci il nuovo modello: ");
                            String modello = sc.nextLine();
                            System.out.print("Inserisci la nuova targa: ");
                            String targa = sc.nextLine();
                            System.out.print("Inserisci il nuovo colore: ");
                            String colore = sc.nextLine();
                            System.out.print("Inserisci la nuova cilindrata: ");
                            Float cilindrata = Float.parseFloat(sc.nextLine());

                            Automobile aggiornata = service.updateAutomobileById(id, marca, modello, targa, colore, cilindrata);
                            System.out.println("Aggiornata con successo:");
                            System.out.println(aggiornata);
                            break;
                        }

                        case 6: {
                            System.out.print("ID da cancellare: ");
                            Integer id = Integer.parseInt(sc.nextLine());
                            service.deleteById(id);
                            System.out.println("Cancellazione completata.");
                            break;
                        }

                        case 0:
                            continua = false;
                            System.out.println("Uscita dal programma.");
                            break;

                        default:
                            System.out.println("Scelta non valida.");
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println("Errore validazione: " + e.getMessage());
                } catch (SQLException e) {
                    System.out.println("Errore SQL: " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.out.println("Errore connessione DB: " + e.getMessage());
        }
    }
}