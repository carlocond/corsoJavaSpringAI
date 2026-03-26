package ui;

import model.Child;
import model.Parent;

public class TestPolimorfismo {
    public static void main(String[] args) {

        Parent ref = new Parent();
        if (ref instanceof Child){
            Child ref2 = (Child) ref; //casting

            ref2.setParentStr3("ciao2");
            ref2.setStringa4("s4");

            ((Child)ref).setParentStr3("s4casting");
        }
        ref = new Child();
        if (ref instanceof Child){
            Child ref2 = (Child) ref; //casting

            ref2.setParentStr3("ciao2");
            ref2.setStringa4("s4");

            ((Child)ref).setParentStr3("s4casting");
        }

        metodo1(new Parent());
        metodo1(new Child());
        metodo2(new Child());

        //metodo2(new Parent()); da errore
    }

    //Casistica 1

    private static void metodo1(Parent x){ //Funziona sia con parent che con child
        x.setStringa1("s1");
        x.setStringa2("s2");
        x.setStringa3("s3");
    }



    private static void metodo2(Child x){ //funziona solo con child
        x.setStringa1("s1");
        x.setStringa2("s2");
        x.setStringa3("s3");
    }

    //Casistica 2

    private static void metodo3(Parent x){
        x.setStringa1("s1");
        x.setStringa2("s2");
        x.setStringa3("s3");
        if (x instanceof Child){
            //Casting di x
            ((Child) x).setStringa4("s4");
        }
    }

    private static void metodo4(Child x){
        x.setStringa1("s1");
        x.setStringa2("s2");
        x.setStringa3("s3");
        x.setStringa4("s4");
    }
}
