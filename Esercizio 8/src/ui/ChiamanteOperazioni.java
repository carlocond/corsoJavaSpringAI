package ui;

import model.Differenza;
import model.Divisione;
import model.Prodotto;
import model.Somma;

import java.util.Scanner;

public class ChiamanteOperazioni {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean continua = false;
        int a;
        int b;
        int result;

        while (!continua){
            System.out.println("1. Somma | 2. Differenza | 3. Prodotto | 4. Divisione | 0. Esci");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    Somma s = new Somma();
                    System.out.println("Inserisci il primo numero");
                    a = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserisci il secondo numero");
                    b = scanner.nextInt();
                    scanner.nextLine();
                    result = s.operate(a, b);
                    s.printResult(result);
                    break;
                case 2:
                    Differenza diff = new Differenza();
                    System.out.println("Inserisci il primo numero");
                    a = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserisci il secondo numero");
                    b = scanner.nextInt();
                    scanner.nextLine();
                    result = diff.operate(a, b);
                    diff.printResult(result);
                    break;
                case 3:
                    Prodotto p = new Prodotto();
                    System.out.println("Inserisci il primo numero");
                    a = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserisci il secondo numero");
                    b = scanner.nextInt();
                    scanner.nextLine();
                    result = p.operate(a, b);
                    p.printResult(result);
                    break;
                case 4:
                    Divisione div = new Divisione();
                    System.out.println("Inserisci il primo numero");
                    a = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserisci il secondo numero");
                    b = scanner.nextInt();
                    scanner.nextLine();
                    result = div.operate(a, b);
                    div.printResult(result);
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
}
