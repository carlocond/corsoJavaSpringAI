package com.azienda.esercizio2springboot.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.azienda.esercizio2springboot.model.Persona;

@Component
public class PersonaRepo {

	private final List<Persona> persone = new ArrayList<>();
	
	public void create(Persona p) {
		persone.add(p);
	}
	
	public Optional<Persona> getPersonaById(Integer id){
		return persone.stream().filter(p -> p.getId().equals(id)).findFirst();
	}
	
	public List<Persona> getAllPersona() {
		List<Persona> result = new ArrayList<>();
		for (Persona p : persone) {
			result .add(p);
		}
		return result;
	}
	
	public boolean update(Persona daCercare, String nuovoNome, String nuovoCognome) {
		for (Persona p : persone) {
			if (p.getId().equals(daCercare.getId())) {
				daCercare.setNome(nuovoNome);
				daCercare.setCognome(nuovoCognome);
				Integer idprec = daCercare.getId();
				daCercare.setId(idprec++);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteById(Integer id) {
		for(Persona p : persone) {
			if (p.getId().equals(id)) {
				persone.remove(p);
				return true;
			}
		}
		return false;
	}
}
