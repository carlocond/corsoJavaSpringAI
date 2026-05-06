package com.azienda.esercizio1SpringData.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azienda.esercizio1SpringData.model.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer>{

	public Optional<Utente> findUserByUsernameAndPassword(String username, String password);
	
}
