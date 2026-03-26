package models;

public class Nonno {

    private String nomeNonno;

    public Nonno(){
        System.out.println("Costruttore nonno");
    }

    public String getNomeNonno() {
        return nomeNonno;
    }

    public void setNomeNonno(String nomeNonno) {
        this.nomeNonno = nomeNonno;
    }
}
