package com.azienda.esercizio1SpringData.service;

import org.springframework.stereotype.Service;

import com.azienda.esercizio1SpringData.constants.CostantiProfilo;
import com.azienda.esercizio1SpringData.model.Profilo;
import com.azienda.esercizio1SpringData.model.Utente;
import com.azienda.esercizio1SpringData.repository.UtenteRepository;

@Service
public class UtenteService {

	private UtenteRepository utenteRepository;
    private ProfiloService profiloService;

    public UtenteService(UtenteRepository utenteRepository, ProfiloService profiloService) {
        this.utenteRepository = utenteRepository;
        this.profiloService = profiloService;
    }

    public Utente saveUtente(String username, String password, String nomeProfilo) {
        Profilo profilo = profiloService.findProfiloByNome(nomeProfilo);
        Utente utente = new Utente(username, password, profilo);
        return utenteRepository.save(utente);
    }

    public boolean login(String username, String password) {
        return utenteRepository.findUserByUsernameAndPassword(username, password).isPresent();
    }

    public boolean isAdmin(String username, String password) {
        return utenteRepository.findUserByUsernameAndPassword(username, password)
                .map(u -> CostantiProfilo.ADMIN.equals(u.getProfilo().getNome()))
                .orElse(false);
    }
    
}
