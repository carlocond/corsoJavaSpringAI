package model;

public class Veicolo {

    private String modello;
    private double cc;

    public Veicolo(String modello, double cc) {
        this.modello = modello;
        this.cc = cc;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public double getCc() {
        return cc;
    }

    public void setCc(double cc) {
        this.cc = cc;
    }
}
