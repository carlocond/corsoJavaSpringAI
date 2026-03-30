package com.azienda.eccezioni.esercizio3.utils;

import com.azienda.eccezioni.esercizio3.exceptions.VeicoloNonValidoException;

public final class Validatore {

	public static final String AEREO = "aereo";
	public static final String TRENO = "treno";
	
	private Validatore() { }
	
	public static void valida(String tipo) throws VeicoloNonValidoException {
		
		if (tipo == null) {
			throw new VeicoloNonValidoException("Inserire un tipo", null);
		}
		
		String t = tipo.trim().toLowerCase();
		if (!AEREO.equals(t) && !TRENO.equals(t)) {
			throw new VeicoloNonValidoException("Tipo non valido", null);
		}
	}
}
