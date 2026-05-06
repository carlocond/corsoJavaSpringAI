package com.azienda.Esercizio1SpringMVC.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.azienda.Esercizio1SpringMVC.model.Indirizzo;
import com.azienda.Esercizio1SpringMVC.repository.IndirizzoRepository;

@Service
public class IndirizzoServiceImpl implements IndirizzoService{

	private final IndirizzoRepository indirizzoRepository;

    public IndirizzoServiceImpl(IndirizzoRepository indirizzoRepository) {
        this.indirizzoRepository = indirizzoRepository;
    }

    @Override
    public List<Indirizzo> findAll() {
        return indirizzoRepository.findAll();
    }

    @Override
    public List<Indirizzo> findByCitta(String citta) {
        return indirizzoRepository.findByCittaContainingIgnoreCase(citta);
    }

    @Override
    public List<Indirizzo> findByCittaOrVia(String citta, String via) {
        return indirizzoRepository.findByCittaContainingIgnoreCaseOrViaContainingIgnoreCase(citta, via);
    }

    @Override
    public Indirizzo save(Indirizzo indirizzo) {
        return indirizzoRepository.save(indirizzo);
    }
	
}
