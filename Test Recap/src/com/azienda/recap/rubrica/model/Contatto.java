package com.azienda.recap.rubrica.model;

import java.util.Objects;

public class Contatto {

    private String nome;
    private String cognome;
    private String numeroTel;

    public Contatto(String nome, String cognome, String numeroTel){
        //Controlli valori nulli e vuoti
        if (nome != null && !nome.trim().isEmpty()){
            this.nome = nome.trim();
        }
        if (cognome != null && !cognome.trim().isEmpty()){
            this.cognome = cognome.trim();
        }
        if (numeroTel != null && !numeroTel.trim().isEmpty()){
            this.numeroTel = numeroTel.trim();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        //Validazione non null e non vuoto
        if (nome != null && !nome.trim().isEmpty()){
            this.nome = nome.trim();
        }
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        //Validazione non null e non vuoto
        if (cognome != null && !cognome.trim().isEmpty()){
            this.cognome = cognome.trim();
        }
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        //Validazione non null e non vuoto
        if (numeroTel != null && !numeroTel.trim().isEmpty()){
            this.numeroTel = numeroTel.trim();
        }
    }

    //UTILITIES
    @Override
    public String toString() {
        return "| Dettagli Contatto |" +
                "\nNome: " + nome +
                "\nCognome: " + cognome +
                "\nNumero: " + numeroTel;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Contatto contatto)) return false;
        return Objects.equals(nome, contatto.nome) &&
                Objects.equals(cognome, contatto.cognome) &&
                Objects.equals(numeroTel, contatto.numeroTel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome, numeroTel);
    }
}
