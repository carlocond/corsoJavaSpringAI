package ui;

import model.Moto;

public class TestEreditarieta2 {
    public static void main(String[] args){

        Moto m = new Moto("YAMAHA", 998, "AB123CD");
        System.out.println(m.getTarga());
        System.out.println(m.getModello());
        System.out.println(m.getCc());



    }
}
