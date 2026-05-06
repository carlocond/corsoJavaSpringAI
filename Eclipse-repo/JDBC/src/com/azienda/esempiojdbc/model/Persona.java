package com.azienda.esempiojdbc.model;

public class Persona {

	private Integer id;
	private String nome;
	private String cognome;
	
	public Persona() {
	}

	public Persona(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	
	
	
	
	
}
