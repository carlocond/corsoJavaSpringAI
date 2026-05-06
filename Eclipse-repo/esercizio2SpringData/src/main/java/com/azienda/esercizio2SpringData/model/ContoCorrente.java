package com.azienda.esercizio2SpringData.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class ContoCorrente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String numeroConto;
    private Float saldo;

    @ManyToOne
    @JoinColumn(name = "banca_id")
    private Banca banca;

    @ManyToMany
    @JoinTable(
        name = "conto_persona",
        joinColumns = @JoinColumn(name = "conto_id"),
        inverseJoinColumns = @JoinColumn(name = "persona_id")
    )
    private List<Persona> intestatari = new ArrayList<>();

    public ContoCorrente() {}

    public ContoCorrente(String numeroConto, Float saldo) {
        this.numeroConto = numeroConto;
        this.saldo = saldo;
    }

    public Integer getId() {
        return id;
    }

    public String getNumeroConto() {
        return numeroConto;
    }

    public Float getSaldo() {
        return saldo;
    }

    public Banca getBanca() {
        return banca;
    }

    public List<Persona> getIntestatari() {
        return intestatari;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumeroConto(String numeroConto) {
        this.numeroConto = numeroConto;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public void setBanca(Banca banca) {
        this.banca = banca;
    }

    public void setIntestatari(List<Persona> intestatari) {
        this.intestatari = intestatari;
    }

    @Override
    public String toString() {
        return "ContoCorrente [id=" + id + ", numeroConto=" + numeroConto + ", saldo=" + saldo + "]";
    }
}
