package com.azienda.esercizio1springboot.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.azienda.esercizio1springboot.model.Banca;
import com.azienda.esercizio1springboot.model.ContoCorrente;

@Component
public class ContoCorrenteImpl implements ContoCorrente{

	private Integer numeroConto;
	private Banca banca;
	
	public ContoCorrenteImpl() {}
	
	@Autowired
	public ContoCorrenteImpl(@Value("12345678") Integer numeroConto, @Qualifier("bancaImpl") Banca banca) {
		this.numeroConto = numeroConto;
		this.banca = banca;
	}

	@Override
	public Integer getNumeroConto() {
		// TODO Auto-generated method stub
		return numeroConto;
	}

	@Override
	public void setNumeroConto(Integer numeroConto) {
		// TODO Auto-generated method stub
		this.numeroConto = numeroConto;
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
		return "| Dettagli ContoCorrente |" + 
				"\nNumero Conto: " + numeroConto + 
				"\nBanca: " + banca;
	}

	@Override
	public int hashCode() {
		return Objects.hash(banca, numeroConto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContoCorrenteImpl other = (ContoCorrenteImpl) obj;
		return Objects.equals(banca, other.banca) && Objects.equals(numeroConto, other.numeroConto);
	}
	
	
	
}
