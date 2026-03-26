package model;

public class Studente extends Persona{

    private double mediaVoti;

    public Studente(String nome, String cognome, double mediaVoti){
        super(nome, cognome);
        this.mediaVoti = mediaVoti;
    }

    public double getMediaVoti() {
        return mediaVoti;
    }

    public void setMediaVoti(double mediaVoti) {
        this.mediaVoti = mediaVoti;
    }

    public String infoStudente(){
        return "Nome: " + getNome() +
                "\nCognome: " + getNome() +
                "\nMedia: " + getMediaVoti();
    }
}
