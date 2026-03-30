package com.azienda.eccezioni.esercizio3.model;

public class CalcoloTempiTreno extends AbstractCalcoloTempi{

	@Override
	public void infoMovimento(Veicolo v) {
		if (v instanceof Treno) {
			((Treno) v).percorreBinari();
		} else {
			System.out.println("Non e' un treno");
		}
		
	}
}
