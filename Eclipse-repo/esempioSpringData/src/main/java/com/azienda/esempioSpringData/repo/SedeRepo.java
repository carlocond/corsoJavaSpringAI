package com.azienda.esempioSpringData.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azienda.esempioSpringData.model.Sede;

public interface SedeRepo extends JpaRepository<Sede, Integer>{

	public Sede findByCitta(String citta);
	
}
