package com.azienda.esercizio1SpringData.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azienda.esercizio1SpringData.model.Profilo;

@Repository
public interface ProfiloRepository extends JpaRepository<Profilo, Integer>{

	public Optional<Profilo> findProfiloByNome(String nome);
}
