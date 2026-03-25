package model;

public class Banca {

    private String nome;
    private Indirizzo indirizzo;

    public Banca(String nome, Indirizzo indirizzo){
        this.nome = nome;
        this.indirizzo = indirizzo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String descrizione(){
        String infoIndirizzo = indirizzo != null ? "\nIndirizzo: " + indirizzo.descrizione() : "";

        return "Nome Banca: " + nome + infoIndirizzo;
    }
}
