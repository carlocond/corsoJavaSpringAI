public class ChiamanteBambino {

    public static void main(String[] args) {

        Bambino b1 = new Bambino("Carlo", "Rossi", 110.5);

        System.out.println(b1.infoBimbo());
        System.out.println("**********************");

        b1.cresce(9.5);
        System.out.println("Informazioni bambino dopo la crescita");
        System.out.println(b1.infoBimbo());

        Bambino b2 = new Bambino("Gianni", "Verdi", 98.2);
        System.out.println(b2.infoBimbo());
        System.out.println("**********************");

        b2.cresce(0.8);
        System.out.println("Informazioni bambino dopo la crescita");
        System.out.println(b2.infoBimbo());

        Bambino[] bambini = { new Bambino("Osvaldo", "Gialli", 100),
                              new Bambino("Giorgio", "Neri", 100),
                              new Bambino("Pippo", "Azzurri", 100),
                              new Bambino("Ciccio", "Rosa", 100),
                              new Bambino("Luca", "Viola", 100),
                              new Bambino("Franco", "Arancioni", 100),
                              new Bambino("Domenico", "Marroni", 100),
                              new Bambino("Max", "Verstappen", 100),
                              new Bambino("Salvatore", "Grigi", 100),
                              new Bambino("Gabriele", "Blu", 100)};

        for (Bambino b : bambini){
            System.out.println(b.infoBimbo());
            b.cresce(10);
            System.out.println("Informazioni bambino dopo la crescita");
            System.out.println(b.infoBimbo());
            System.out.println("**********************");
        }

        System.out.println("Il numero di bambini complessivamente creati ammonta a: " + Bambino.numeroBambini);

    }
}
