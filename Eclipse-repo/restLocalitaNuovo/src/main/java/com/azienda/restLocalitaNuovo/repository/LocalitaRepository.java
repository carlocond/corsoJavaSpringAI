package com.azienda.restLocalitaNuovo.repository;

import com.azienda.restLocalitaNuovo.model.Localita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocalitaRepository extends JpaRepository<Localita, Long> {
  Optional<Localita> findByNomeIgnoreCase(String nome);

  long deleteByTemperaturaLessThan(Double valore);
}
