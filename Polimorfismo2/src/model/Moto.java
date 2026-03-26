package model;

public class Moto extends Veicolo{

    private String targa;

    public Moto(){
        super("50ino", 50.0);
    }

    public Moto(String modello, double cc, String targa){
        super(modello, cc);
        this.targa = targa;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }
}
