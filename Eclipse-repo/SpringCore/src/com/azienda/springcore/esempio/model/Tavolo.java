package com.azienda.springcore.esempio.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Tavolo {
	
	private String materiale;
	private Stanza stanza;
	private Float metriQuadri;
	
	/*
	 public Tavolo() {
	}
	 */
	
	public Tavolo(@Value("legno") String materiale, @Value("10f") Float metriQuadri, @Qualifier("stanza2") Stanza stanza) {
		this.materiale = materiale;
		this.metriQuadri = metriQuadri;
		this.stanza = stanza;
	}

	public String getMateriale() {
		return materiale;
	}
	public void setMateriale(String materiale) {
		this.materiale = materiale;
	}
	public Float getMetriQuadri() {
		return metriQuadri;
	}
	public void setMetriQuadri(Float metriQuadri) {
		this.metriQuadri = metriQuadri;
	}
	public Stanza getStanza() {
		return stanza;
	}
	public void setStanza(Stanza stanza) {
		this.stanza = stanza;
	}

	@Override
	public String toString() {
		return "Tavolo [materiale=" + materiale + ", metriQuadri=" + metriQuadri + ", stanza=" + stanza + "]";
	}
	
	
	
}
