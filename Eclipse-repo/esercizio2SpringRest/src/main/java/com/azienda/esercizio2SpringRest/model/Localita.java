package com.azienda.esercizio2SpringRest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "localita")
public class Localita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double temperatura;

    public Localita() {
    }

    public Localita(Integer id, String nome, Double temperatura) {
        this.id = id;
        this.nome = nome;
        this.temperatura = temperatura;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }
}
