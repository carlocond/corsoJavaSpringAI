package com.azienda.esercizio2springboot.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azienda.esercizio2springboot.model.Persona;

@Component
public class PersonaImpl implements Persona{

	private Integer id;
	private String nome;
	private String cognome;
	
	public PersonaImpl() {}
	
	@Autowired
	public PersonaImpl(Integer id, String nome, String cognome) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}

	@Override
	public void setNome(String nome) {
		// TODO Auto-generated method stub
		this.nome = nome;
	}

	@Override
	public String getCognome() {
		// TODO Auto-generated method stub
		return cognome;
	}

	@Override
	public void setCognome(String cognome) {
		// TODO Auto-generated method stub
		this.cognome = cognome;
	}

	@Override
	public String toString() {
		return "| Dettagli PersonaImpl |" + 
				"\n| Id: " + id + " | Nome: " + nome + " | Cognome: " + cognome + "|";
	}
	
	
}
