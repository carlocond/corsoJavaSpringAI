package com.azienda.recap.rubrica.model;

import java.util.LinkedList;
import java.util.List;

public class Rubrica {

    private String nome;
    private int anno;
    private final List<Contatto> contatti;

    public Rubrica(String nome, int anno){
        if (nome != null && !nome.trim().isEmpty()){
            this.nome = nome.trim();
        }
        if (anno > 0) {
            this.anno = anno;
        }
        this.contatti = new LinkedList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public List<Contatto> getContatti() {
        return contatti;
    }

    @Override
    public String toString() {
        return "| Dettagli Rubrica |" +
                "\nNome: " + nome +
                "\nAnno di creazione: " + anno +
                "\nContatti presenti: " + contatti.size();
    }
}
