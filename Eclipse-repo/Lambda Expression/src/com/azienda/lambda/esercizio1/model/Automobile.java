package com.azienda.lambda.esercizio1.model;

import java.time.LocalDate;

public class Automobile {

	private String marca;
	private String modello;
	private int cc;
	private LocalDate dataImmatricolazione;
	
	public Automobile(String marca, String modello, int cc, LocalDate dataImmatricolazione) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.cc = cc;
		this.dataImmatricolazione = dataImmatricolazione;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public LocalDate getDataImmatricolazione() {
		return dataImmatricolazione;
	}

	public void setDataImmatricolazione(LocalDate dataImmatricolazione) {
		this.dataImmatricolazione = dataImmatricolazione;
	}

	@Override
	public String toString() {
		return "Automobile [marca=" + marca + ", modello=" + modello + ", cc=" + cc + ", dataImmatricolazione="
				+ dataImmatricolazione + "]";
	}
	
	
	
}
