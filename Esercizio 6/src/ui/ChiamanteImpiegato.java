package ui;

import model.Impiegato;
import model.Persona;

public class ChiamanteImpiegato {
    public static void main(String[] args) {

        Persona obj = new Persona("Mario", "Rossi");
        System.out.println(obj);

        Persona obj2 = new Persona("Mario", "Rossi");
        System.out.println(obj2);

        if (obj.equals(obj2)){
            System.out.println("Sono uguali");
        } else {
            System.out.println("Sono diversi ");
        }

        obj = new Impiegato("Mario", "Rossi", "21322");
        System.out.println(obj);

        ((Impiegato) obj).setMatricola("20202");
        System.out.println("Nuova matricola: " + ((Impiegato) obj).getMatricola());
    }
}
