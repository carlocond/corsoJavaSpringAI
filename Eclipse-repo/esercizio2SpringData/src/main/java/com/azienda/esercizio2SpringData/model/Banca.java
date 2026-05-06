package com.azienda.esercizio2SpringData.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Banca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "banca")
    private List<ContoCorrente> contiCorrenti = new ArrayList<>();

    public Banca() {}

    public Banca(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
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

    public void setContiCorrenti(List<ContoCorrente> contiCorrenti) {
        this.contiCorrenti = contiCorrenti;
    }

    @Override
    public String toString() {
        return "Banca [id=" + id + ", nome=" + nome + "]";
    }
}