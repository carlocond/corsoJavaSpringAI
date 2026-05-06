package com.azienda.springcore.esempio.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Stanza {

	private String nome;
	private String colore;
	
	@Autowired
	@Value("14f")
	private Float metriQuadri;
	
	
	
	public Stanza() {}
	 
	@Autowired
	public Stanza(@Value("Cucina") String nome, @Value("rosso")String colore, @Value("5f") Float metriQuadri) {
		this.nome = nome;
		this.colore = colore;
		this.metriQuadri = metriQuadri;
	}


	public Stanza(String nome, Float metriQuadri) {
		this.nome = nome;
		this.metriQuadri = metriQuadri;
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


	public Float getMetriQuadri() {
		return metriQuadri;
	}


	public void setMetriQuadri(Float metriQuadri) {
		this.metriQuadri = metriQuadri;
	}


	@Override
	public String toString() {
		return "Stanza [nome=" + nome + ", colore=" + colore + ", metriQuadri=" + metriQuadri + "]";
	}
	
	
	
	
	
}
