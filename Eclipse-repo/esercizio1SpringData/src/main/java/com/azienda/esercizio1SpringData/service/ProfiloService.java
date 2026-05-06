package com.azienda.esercizio1SpringData.service;

import org.springframework.stereotype.Service;

import com.azienda.esercizio1SpringData.constants.CostantiProfilo;
import com.azienda.esercizio1SpringData.model.Profilo;
import com.azienda.esercizio1SpringData.repository.ProfiloRepository;

@Service
public class ProfiloService {

	private ProfiloRepository profiloRepository;
	
	public ProfiloService(ProfiloRepository profiloRepository) {
		this.profiloRepository = profiloRepository;
	}
	
	public Profilo saveProfiloAdmin() {
		return profiloRepository.findProfiloByNome(CostantiProfilo.ADMIN)
				.orElseGet(() -> profiloRepository.save(new Profilo(CostantiProfilo.ADMIN)));
	}
	
	public Profilo saveProfiloUser() {
		return profiloRepository.findProfiloByNome(CostantiProfilo.USER)
				.orElseGet(() -> profiloRepository.save(new Profilo(CostantiProfilo.USER)));
	}
	
	public Profilo findProfiloByNome(String nome) {
		return profiloRepository.findProfiloByNome(nome)
				.orElseThrow(() -> new RuntimeException("Profilo non trovato: " + nome));
	}

}
