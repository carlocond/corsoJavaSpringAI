package models;

public class Figlio extends Padre{

    private String nomeFiglio;

    public Figlio(){
        System.out.println("Costruttore figlio");
    }

    public String getNomeFiglio() {
        return nomeFiglio;
    }

    public void setNomeFiglio(String nomeFiglio) {
        this.nomeFiglio = nomeFiglio;
    }
}
