package com.azienda.esercizio2SpringData.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String cognome;

    @ManyToMany(mappedBy = "intestatari")
    private List<ContoCorrente> contiCorrenti = new ArrayList<>();

    public Persona() {}

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public List<ContoCorrente> getContiCorrenti() {
        return contiCorrenti;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setContiCorrenti(List<ContoCorrente> contiCorrenti) {
        this.contiCorrenti = contiCorrenti;
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + "]";
    }
}
