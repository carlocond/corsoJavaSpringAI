package com.azienda.Esercizio1SpringMVC.model;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Indirizzo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String citta;
	private String via;
	private Integer numCivico;
	
	public Indirizzo() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Autowired
	public Indirizzo(String citta, String via, Integer numCivico) {
		super();
		this.citta = citta;
		this.via = via;
		this.numCivico = numCivico;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public Integer getNumCivico() {
		return numCivico;
	}

	public void setNumCivico(Integer numCivico) {
		this.numCivico = numCivico;
	}

	@Override
	public String toString() {
		return "Indirizzo [id=" + id + ", citta=" + citta + ", via=" + via + ", numCivico=" + numCivico + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(citta, id, numCivico, via);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Indirizzo))
			return false;
		Indirizzo other = (Indirizzo) obj;
		return Objects.equals(citta, other.citta) && Objects.equals(id, other.id)
				&& Objects.equals(numCivico, other.numCivico) && Objects.equals(via, other.via);
	}
	
}
