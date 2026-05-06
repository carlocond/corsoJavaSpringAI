package com.azienda.springcore.esercizio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azienda.springcore.esercizio.model.Indirizzo;

@Component("indirizzo")
public class IndirizzoImpl implements Indirizzo{

	private String comune;
	private String stradaPiazza;
	private Integer numeroCivico;
	
	@Autowired
	public IndirizzoImpl() {
		this.comune = "Roma";
		this.stradaPiazza = "Via Colombo";
		this.numeroCivico = 1;
	}
	
	public IndirizzoImpl(String comune, String stradaPiazza, Integer numeroCivico) {
		this.comune = comune;
		this.stradaPiazza = stradaPiazza;
		this.numeroCivico = numeroCivico;
	}

	@Override
	public String getComune() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setComune(String comune) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getStradaPiazza() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStradaPiazza(String stradaPiazza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getNumeroCivico() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNumeroCivico(Integer numeroCivico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "| Dettagli Indirizzo | " + 
				"\nComune: " + comune + 
				"\nStrada Piazza: " + stradaPiazza + 
				"\nNumero Civico: " + numeroCivico;
	}
	
}
