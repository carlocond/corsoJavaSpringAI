package ui;

import model.Child;
import model.Parent;

public class TestOverride {
    public static void main(String[] args) {

        Child c = new Child();

        c.setStringa1("s1");
        c.setStringa2("s2");
        c.setStringa3("s3");
        c.setStringa4("s4");
        c.setParentStr3("sp3");

        System.out.println("Programma terminato");
    }

}
