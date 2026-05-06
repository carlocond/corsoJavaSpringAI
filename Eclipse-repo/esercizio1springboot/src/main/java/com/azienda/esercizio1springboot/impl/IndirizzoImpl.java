package com.azienda.esercizio1springboot.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.azienda.esercizio1springboot.model.Indirizzo;

@Component
public class IndirizzoImpl implements Indirizzo{
	
	private String comune;
	private String stradaPiazza;
	private Integer numCivico;
	
	public IndirizzoImpl() {}
	
	@Autowired
	public IndirizzoImpl(@Value("Roma") String comune, @Value("Via Colombo") String stradaPiazza, @Value("1") Integer numCivico) {
		this.comune = comune;
		this.stradaPiazza = stradaPiazza;
		this.numCivico = numCivico;
	}

	@Override
	public String getComune() {
		// TODO Auto-generated method stub
		return comune;
	}

	@Override
	public void setComune(String comune) {
		// TODO Auto-generated method stub
		this.comune = comune;
	}

	@Override
	public String getStradaPiazza() {
		// TODO Auto-generated method stub
		return stradaPiazza;
	}

	@Override
	public void setStradaPiazza(String stradaPiazza) {
		// TODO Auto-generated method stub
		this.stradaPiazza = stradaPiazza;
	}

	@Override
	public Integer getNumeroCivico() {
		// TODO Auto-generated method stub
		return numCivico;
	}

	@Override
	public void setNumeroCivico(Integer numCivico) {
		// TODO Auto-generated method stub
		this.numCivico = numCivico;
	}

	@Override
	public String toString() {
		return "| Dettagli Indirizzo | " + 
				"\nComune: " + comune + 
				"\nStrada/Piazza: " + stradaPiazza + 
				"\nNumero Civico: " + numCivico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comune, numCivico, stradaPiazza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IndirizzoImpl other = (IndirizzoImpl) obj;
		return Objects.equals(comune, other.comune) && Objects.equals(numCivico, other.numCivico)
				&& Objects.equals(stradaPiazza, other.stradaPiazza);
	}
	
	
	
	

}
