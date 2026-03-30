package com.azienda.eccezioni.esercizio3.model;

public abstract class AbstractCalcoloTempi implements CalcolaTempi{
	
	@Override
	public float calcolaTempiPercorrenza(Veicolo v, float distanza) {
		if (v == null || distanza <= 0) return 0;
		if (v.getVelocita() <= 0) return 0;
		
		return distanza / v.getVelocita();
	}

}
