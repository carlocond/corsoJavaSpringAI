package model;

public class Stanza {

    private String nome;
    private String colore;
    private float metriQuadri;
    private float altezza;

    public Stanza(String nome, String colore, float metriQuadri, float altezza){
        this.nome = nome;
        this.colore = colore;
        this.metriQuadri = metriQuadri;
        this.altezza = altezza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public float getMetriQuadri() {
        return metriQuadri;
    }

    public void setMetriQuadri(float metriQuadri) {
        this.metriQuadri = metriQuadri;
    }

    public float getAltezza() {
        return altezza;
    }

    public void setAltezza(float altezza) {
        this.altezza = altezza;
    }

    public void incrementaMetriQuadri(float metraggio){
        if (metraggio > 0){
            metriQuadri += metraggio;
        } else {
            System.out.println("Valore non valido");
        }

    }

    public float incrementaAltezza(float metraggio){
        if (metraggio > 0){
            altezza += metraggio;
        } else {
            System.out.println("Valore non valido");
        }
        return altezza;
    }

    public String stampaStanza(){
        return "Nome: " + nome +
                "\nColore: " + colore +
                "\nMetri quadri: " + metriQuadri + "m^2" +
                "\nAltezza: " + altezza + "m.";
    }
}
