package model;

public class Lavoratore extends Persona{

    private double stipendio;

    public Lavoratore(String nome, String cognome, double stipendio){
        super(nome, cognome);
        this.stipendio = stipendio;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public String infoLavoratore(){
        return "Nome: " + getNome() +
                "\nCognome: " + getNome() +
                "\nStipendio: " + getStipendio();
    }
}
