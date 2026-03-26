package model;

public class Bottiglia {

    private String contenuto;
    private String materiale;
    private double capacitaMax;
    private double quantitaAtt;

    public Bottiglia(String contenuto, String materiale, double capacitaMax, double quantitaAtt){
        this.contenuto = contenuto;
        this.materiale = materiale;
        this.capacitaMax = capacitaMax;
        this.quantitaAtt = quantitaAtt;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public String getMateriale() {
        return materiale;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public double getCapacitaMax() {
        return capacitaMax;
    }

    public void setCapacitaMax(double capacitaMax) {
        this.capacitaMax = capacitaMax;
    }

    public double getQuantitaAtt() {
        return quantitaAtt;
    }

    public void setQuantitaAtt(double quantitaAtt) {
        this.quantitaAtt = quantitaAtt;
    }

    public boolean isEmpty(){
        return quantitaAtt == 0;
    }

    public boolean isFull(){
        return quantitaAtt == capacitaMax;
    }

    public String stampaBottiglia(){
        return "Contenuto: " + contenuto +
                "\nMateriale: " + materiale +
                "\nCapacita' Massima: " + capacitaMax + "l" +
                "\nQuantita' Attuale: " + quantitaAtt + "l";
    }

    public boolean aggiungi(double liquido){
        if (isFull()) return false;

        if (quantitaAtt + liquido <= capacitaMax){
            quantitaAtt += liquido;
            return true;
        }
        return false;
    }

    public boolean preleva(double liquido){
        if (isEmpty()) return false;

        if (quantitaAtt >= liquido){
            quantitaAtt -= liquido;
            return true;
        }
        return false;
    }
}
