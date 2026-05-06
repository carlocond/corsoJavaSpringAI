package com.azienda.esercizio2springboot.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azienda.esercizio2springboot.model.Macchina;

@Component
public class MacchinaImpl implements Macchina{
	
	private Integer id;
	private String modello;
	private Integer cilindrata;
	
	public MacchinaImpl() {}
	
	@Autowired
	public MacchinaImpl(Integer id, String modello, Integer cilindrata) {
		this.id = id;
		this.modello = modello;
		this.cilindrata = cilindrata;
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
	public String getModello() {
		// TODO Auto-generated method stub
		return modello;
	}

	@Override
	public void setModello(String modello) {
		// TODO Auto-generated method stub
		this.modello = modello;
	}

	@Override
	public Integer getCilindrata() {
		// TODO Auto-generated method stub
		return cilindrata;
	}

	@Override
	public void setCilindrata(Integer cilindrata) {
		// TODO Auto-generated method stub
		this.cilindrata = cilindrata;
	}

	@Override
	public String toString() {
		return "| Dettagli Macchina |" + 
				"\n| ID: " + id + " | Modello: " + modello + " | Cilindrata: " + cilindrata + " |";
	}
	
	

}
