package com.azienda.esercizio2SpringRest.repository;

import com.azienda.esercizio2SpringRest.model.Localita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocalitaRepository extends JpaRepository<Localita, Integer> {

    Optional<Localita> findByNomeIgnoreCase(String nome);

    List<Localita> findByTemperaturaLessThan(Double temperatura);

    List<Localita> findByTemperaturaGreaterThan(Double temperatura);

    long deleteByTemperaturaLessThan(Double temperatura);

    long deleteByTemperaturaGreaterThan(Double temperatura);
    
}
