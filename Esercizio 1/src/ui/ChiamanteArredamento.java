package ui;

import model.Stanza;
import model.Tavolo;

public class ChiamanteArredamento {
    public static void main(String[] args){

        Stanza stanza = new Stanza("Soggiorno", "Grigio chiaro", 12f, 4f);

        System.out.println(stanza.stampaStanza());

        stanza.incrementaMetriQuadri(2f);
        stanza.incrementaAltezza(1f);

        System.out.println("**********************");
        System.out.println(stanza.stampaStanza());
        System.out.println("**********************");

        Tavolo t1 = new Tavolo("Mogano", 130f, 90f, 4f, stanza);
        Tavolo t2 = new Tavolo("Quercia", 110f, 60f, 2f, stanza);

        System.out.println(t1.descrizioneTavolo());
        System.out.println("**********************");
        System.out.println(t2.descrizioneTavolo());
    }
}
