package com.azienda.Esercizio1SpringMVC.service;

import java.util.List;

import com.azienda.Esercizio1SpringMVC.model.Indirizzo;


public interface IndirizzoService {
	
	List<Indirizzo> findAll();

    List<Indirizzo> findByCitta(String citta);

    List<Indirizzo> findByCittaOrVia(String citta, String via);

    Indirizzo save(Indirizzo indirizzo);
}
