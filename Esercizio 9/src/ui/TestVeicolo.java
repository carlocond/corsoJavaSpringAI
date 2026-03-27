package ui;

import model.*;

import java.util.Scanner;

public class TestVeicolo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Veicolo v = null;
        boolean continua = false;
        float vMax;

        while (!continua){
            System.out.println("1. Auto | 2. Aereo | 3. Treno | 4. Nave | 0. Esci");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    Automobile auto = new Automobile();

                    System.out.println("Inserisci la velocita' max: ");
                    vMax = scanner.nextFloat();
                    auto.setVelocitaMax(vMax);

                    System.out.println("Inserisci cc: ");
                    int cc = scanner.nextInt();
                    scanner.nextLine();
                    auto.setCc(cc);

                    v = auto;
                    stampaInfo(v);
                    break;
                case 2:
                    Treno t = new Treno();
                    System.out.print("Inserisci velocita max: ");
                    vMax = scanner.nextFloat();
                    t.setVelocitaMax(vMax);
                    scanner.nextLine();

                    System.out.print("Inserisci localita partenza: ");
                    String partenza = scanner.nextLine();
                    t.setLocalitaPartenza(partenza);

                    System.out.print("Inserisci localita arrivo: ");
                    String arrivo = scanner.nextLine();
                    t.setLocalitaArrivo(arrivo);

                    v = t;
                    stampaInfo(v);
                    break;
                case 3:
                    Aereo aer = new Aereo();
                    System.out.print("Inserisci velocita max: ");
                    vMax = scanner.nextFloat();
                    aer.setVelocitaMax(vMax);

                    System.out.print("E' di linea? (si/no): ");
                    String risposta = scanner.nextLine().toLowerCase();
                    if (risposta.startsWith("s")){
                        aer.setDiLinea(true);
                    } else {
                        aer.setDiLinea(false);
                    }

                    v = aer;
                    stampaInfo(v);
                    break;
                case 4:
                    Nave n = new Nave();
                    System.out.print("Inserisci velocita max: ");
                    vMax = scanner.nextFloat();
                    n.setVelocitaMax(vMax);

                    System.out.print("Inserisci numero cabine: ");
                    int numCabine = scanner.nextInt();
                    scanner.nextLine();
                    n.setNumeroCabine(numCabine);

                    v = n;
                    stampaInfo(v);
                    break;
                case 0:
                    System.out.println("Arrivederci");
                    continua = true;
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }
        }
        scanner.close();
    }

    public static void stampaInfo(Veicolo v){
        v.setVelocitaMax(v.getVelocitaMax());
        System.out.println("La velocita' massima del veicolo: " + v.getVelocitaMax());

        if (v instanceof Automobile){
            ((Automobile) v).setCc(((Automobile) v).getCc());
        }

        else if (v instanceof Treno){
            ((Treno) v).setLocalitaPartenza(((Treno) v).getLocalitaPartenza());
            ((Treno) v).setLocalitaArrivo(((Treno) v).getLocalitaArrivo());
        }

        else if (v instanceof Aereo){
            ((Aereo) v).setDiLinea(((Aereo) v).getDiLinea());
        }

        else if (v instanceof Nave) {
            ((Nave) v).setNumeroCabine(((Nave) v).getNumeroCabine());
        }

        System.out.println("Informazioni veicolo: " + v.toString());
    }
}
