package com.azienda.esercizio2springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azienda.esercizio2springboot.repo.MacchinaRepo;
import com.azienda.esercizio2springboot.repo.PersonaRepo;

@Component
public class MPService {

	
	@Autowired
	private PersonaRepo personaRepo;
	
	@Autowired
    private MacchinaRepo macchinaRepo;
}
