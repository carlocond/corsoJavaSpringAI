package com.azienda.restClient2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Localita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private Float temperatura;
	
	public Localita() {	}
	
	

	public Localita(String nome, Float temperatura) {
		super();
		this.nome = nome;
		this.temperatura = temperatura;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Float temperatura) {
		this.temperatura = temperatura;
	}



	@Override
	public String toString() {
		return "Localita [id=" + id + ", nome=" + nome + ", temperatura=" + temperatura + "]";
	}
	
}
