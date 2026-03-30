package com.azienda.eccezioni.esercizio3.model;

public class CalcoloTempiAereo extends AbstractCalcoloTempi{
	
	@Override
	public void infoMovimento(Veicolo v) {
		if (v instanceof Aereo) {
			((Aereo) v).vola();
		} else {
			System.out.println("Non e' un aereo");
		}
	}

}
