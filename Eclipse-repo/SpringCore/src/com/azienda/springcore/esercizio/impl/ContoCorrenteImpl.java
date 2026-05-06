package com.azienda.springcore.esercizio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.azienda.springcore.esercizio.model.Banca;
import com.azienda.springcore.esercizio.model.ContoCorrente;

@Component("contoCorrente")
public class ContoCorrenteImpl implements ContoCorrente{

	private Integer numero;
	private Banca banca;
	
	@Autowired
	public ContoCorrenteImpl(@Qualifier("banca") Banca banca) {
		this.numero = 12345678;
		this.banca = banca;
	}
	
	public ContoCorrenteImpl(Integer numero, Banca banca) {
        this.numero = numero;
        this.banca = banca;
    }

	@Override
	public Integer getNumero() {
		// TODO Auto-generated method stub
		return numero;
	}

	@Override
	public void setNumero(Integer numero) {
		// TODO Auto-generated method stub
		this.numero = numero;
	}

	@Override
	public Banca getBanca() {
		// TODO Auto-generated method stub
		return banca;
	}

	@Override
	public void setBanca(Banca banca) {
		// TODO Auto-generated method stub
		this.banca = banca;
	}

	@Override
	public String toString() {
		return "| Dettagli ContoCorrente | " + 
				"\nNumero conto: " + numero + 
				"\nBanca: " + banca;
	}
	
	
	
}
