package com.azienda.esempioSpringData.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azienda.esempioSpringData.model.Ruolo;

public interface RuoloRepo extends JpaRepository<Ruolo, Integer> {

	public Ruolo findByNome(String nome);
	
}
