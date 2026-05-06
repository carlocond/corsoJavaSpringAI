package com.azienda.esercizio2SpringData.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azienda.esercizio2SpringData.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer>{

	Optional<Persona> findPersonaByNomeAndCognome(String nome, String cognome);
}
