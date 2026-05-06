package com.azienda.esercizio1SpringRest.model;

public class Localita {

	private Integer id;
    private String nome;
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
