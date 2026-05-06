package com.azienda.esercizio2SpringData.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.azienda.esercizio2SpringData.model.Banca;
import com.azienda.esercizio2SpringData.model.ContoCorrente;
import com.azienda.esercizio2SpringData.model.Persona;
import com.azienda.esercizio2SpringData.repo.BancaRepository;
import com.azienda.esercizio2SpringData.repo.ContoCorrenteRepository;
import com.azienda.esercizio2SpringData.repo.PersonaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AppService {
	
	private BancaRepository bancaRepository;
	private ContoCorrenteRepository contoCorrenteRepository;
	private PersonaRepository personaRepository;
	
	public AppService(BancaRepository bancaRepository, ContoCorrenteRepository contoCorrenteRepository, PersonaRepository personaRepository) {
				this.bancaRepository = bancaRepository;
				this.contoCorrenteRepository = contoCorrenteRepository;
				this.personaRepository = personaRepository;
	}
	
	public void create(Persona persona, List<ContoCorrente> conti, Banca banca) {

        Banca b;
        if (banca.getId() == null) {
            b = bancaRepository.save(banca);
        } else {
            b = bancaRepository.findById(banca.getId()).orElseGet(() -> bancaRepository.save(banca));
        }
        
        Persona p = personaRepository.save(persona);

        for (ContoCorrente conto : conti) {
            conto.setBanca(b);
            conto.getIntestatari().add(p);
            contoCorrenteRepository.save(conto);

            p.getContiCorrenti().add(conto);
        }

        personaRepository.save(p);
    }
	
	public void spostaFondi(String nome1, String cognome1, String nome2, String cognome2, Float importo) {

        Optional<Persona> persona1 = personaRepository.findPersonaByNomeAndCognome(nome1, cognome1);
        Optional<Persona> persona2 = personaRepository.findPersonaByNomeAndCognome(nome2, cognome2);

        if (persona1.isPresent() && persona2.isPresent()) {
            Persona p1 = persona1.get();
            Persona p2 = persona2.get();

            for (ContoCorrente c1 : p1.getContiCorrenti()) {
                c1.setSaldo(c1.getSaldo() - importo);
                contoCorrenteRepository.save(c1);
            }

            for (ContoCorrente c2 : p2.getContiCorrenti()) {
                c2.setSaldo(c2.getSaldo() + importo);
                contoCorrenteRepository.save(c2);
            }
        }
    }
	
	

}
