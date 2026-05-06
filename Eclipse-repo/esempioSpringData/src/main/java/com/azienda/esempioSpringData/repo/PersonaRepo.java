package com.azienda.esempioSpringData.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azienda.esempioSpringData.model.Persona;

public interface PersonaRepo extends JpaRepository<Persona, Integer> {

	public List<Persona> findByCognome(String cognome);
	public List<Persona> findByCognomeLike(String cognome);
	public List<Persona> findByNomeAndCognome(String nome, String cognome);
	public List<Persona> findByIdBetween(Integer idStart, Integer IdEnd);
	
}
