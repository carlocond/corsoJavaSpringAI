package models;

public class Padre extends Nonno{

    private String nomePadre;

    public Padre(){
        System.out.println("Costruttore padre");
    }

    public String getNomePadre() {
        return nomePadre;
    }

    public void setNomePadre(String nomePadre) {
        this.nomePadre = nomePadre;
    }
}
