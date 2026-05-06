package com.azienda.Esercizio1SpringMVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azienda.Esercizio1SpringMVC.model.Indirizzo;

@Repository
public interface IndirizzoRepository extends JpaRepository<Indirizzo, Integer>{

	List<Indirizzo> findByCittaContainingIgnoreCase(String citta);

    List<Indirizzo> findByCittaContainingIgnoreCaseOrViaContainingIgnoreCase(String citta, String via);
	
}
