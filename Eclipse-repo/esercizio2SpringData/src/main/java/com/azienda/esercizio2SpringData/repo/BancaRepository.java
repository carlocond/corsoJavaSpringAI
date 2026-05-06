package com.azienda.esercizio2SpringData.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azienda.esercizio2SpringData.model.Banca;

@Repository
public interface BancaRepository extends JpaRepository<Banca, Integer>{

}
