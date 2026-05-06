package com.azienda.esempioSpringData.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.azienda.esempioSpringData.model.Lavoratore;
import com.azienda.esempioSpringData.model.Persona;
import com.azienda.esempioSpringData.model.Ruolo;
import com.azienda.esempioSpringData.model.Sede;
import com.azienda.esempioSpringData.repo.LavoratoreRepo;
import com.azienda.esempioSpringData.repo.PersonaRepo;
import com.azienda.esempioSpringData.repo.RuoloRepo;
import com.azienda.esempioSpringData.repo.SedeRepo;

@Service
@Transactional
public class AppService {

	@Autowired
	private PersonaRepo personaRepo;
	
	@Autowired
	private LavoratoreRepo lavoratoreRepo;
	
	@Autowired
	private SedeRepo sedeRepo;
	
	@Autowired
	private RuoloRepo ruoloRepo;
	
	public void savePersonaLavoratore(String nome, String cognome, Integer matricola, Float stipendio) {
		
		Persona p = new Persona(nome, cognome);

		Lavoratore lav = new Lavoratore(matricola, stipendio);
		
		lav.setPersona(p);
		
		personaRepo.save(p);
		lavoratoreRepo.save(lav);

	}
	
	public List<Persona> getAllPersone(){
		
		List<Persona> result = personaRepo.findAll();
		
		return result;
	}
	
	public List<Lavoratore> getAllLavoratori(){
		
		List<Lavoratore> result = lavoratoreRepo.findAll();
		
		return result;
	}
	
	public Persona getPersonaById(Integer id) {
		Optional<Persona> opt = personaRepo.findById(id);
		
		return opt.orElse(null);
	}
	
	public void updatePersonaById(Integer id, String nuovoNome, String nuovoCognome) {
		Optional<Persona> opt = personaRepo.findById(id);

		Persona p = opt.orElse(null);
		if (p != null) {
			p.setNome(nuovoNome);
			p.setCognome(nuovoCognome);
		}
	}
	
	public void deleteLavoratoreById(Integer id) {
		Optional<Lavoratore> opt = lavoratoreRepo.findById(id);
		Optional<Persona> opt2 = personaRepo.findById(id);

		Lavoratore lav = opt.orElse(null);
		Persona p = opt2.orElse(null);
		if (lav != null && p != null) {
			lavoratoreRepo.delete(lav);
			personaRepo.delete(p);
		}
	}
	
	public void assunzione(Integer matricola, Float stipendio, String citta) {
		Lavoratore lav = new Lavoratore(matricola, stipendio);
		Sede s = sedeRepo.findByCitta(citta);
		
		if (s == null) {
			throw new RuntimeException("Sede della " + citta + " non esiste.");
		}
		
		lav.setSede(s);
		//s.getLavoratori().add(lav);
		lavoratoreRepo.save(lav);
	}
	
	public void saveSede(String citta) {
		
		if (sedeRepo.findByCitta(citta) != null) {
			throw new RuntimeException("La sede della " + citta + " esiste gia.");
		}
		
		Sede s = new Sede(citta);
		sedeRepo.save(s);
	}
	
	public void getLavoratoreByStipendioBetween(Float f1, Float f2) {
		List<Lavoratore> lavoratori = lavoratoreRepo.findByStipendioBetween(f1, f2);
		
		for (Lavoratore l : lavoratori) {
			System.out.println(l);
		}
	}
	
	public void getSede(String citta) {
		Sede s = sedeRepo.findByCitta(citta);
		System.out.println(s);
		List<Lavoratore> lavoratori = s.getLavoratori();
		for (Lavoratore l : lavoratori) {
			System.out.println(l);
		}
	}
	
	public void saveRuolo(String nome) {
		
		if (ruoloRepo.findByNome(nome) != null) {
			throw new RuntimeException("Il ruolo con nome: " + nome + " esiste gia");
		}
		
		Ruolo r = new Ruolo(nome);
		ruoloRepo.save(r);
	}
	
	public void assegnaRuolo(Integer matricola, Float stipendio, String nomeRuolo) {
		Ruolo r = ruoloRepo.findByNome(nomeRuolo);
		
		if (r == null) {
			throw new RuntimeException("Il ruolo con nome: " + nomeRuolo + " non esiste");
		}
		
		Lavoratore l = new Lavoratore(matricola, stipendio);
		l.getRuoli().add(r);
		//r.getLavoratori().add(l);
		
		lavoratoreRepo.save(l);
		
	}
	
	public void getRuolo(String nome) {
		Ruolo r = ruoloRepo.findByNome(nome);
		
		System.out.println(r);
	}
	
}












