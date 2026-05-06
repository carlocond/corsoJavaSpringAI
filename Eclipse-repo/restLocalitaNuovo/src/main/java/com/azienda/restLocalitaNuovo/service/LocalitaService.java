package com.azienda.restLocalitaNuovo.service;

import com.azienda.restLocalitaNuovo.dto.*;
import com.azienda.restLocalitaNuovo.model.Localita;
import com.azienda.restLocalitaNuovo.exception.ResourceNotFoundException;
import com.azienda.restLocalitaNuovo.exception.ResourceNotValidException;
import com.azienda.restLocalitaNuovo.repository.LocalitaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocalitaService {

  private final LocalitaRepository repository;

  public LocalitaService(LocalitaRepository repository) {
    this.repository = repository;
  }

  public List<LocalitaResponse> getAll() {
    return repository.findAll().stream().map(this::toResponse).toList();
  }

  public LocalitaResponse getById(Long id) {
    Localita l = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Localita con id=" + id + " non trovata"));
    return toResponse(l);
  }

  public LocalitaResponse getByNome(String nome) {
    Localita l = repository.findByNomeIgnoreCase(nome)
        .orElseThrow(() -> new ResourceNotFoundException("Localita con nome='" + nome + "' non trovata"));
    return toResponse(l);
  }

  @Transactional
  public LocalitaResponse create(LocalitaCreateRequest req) {
    Localita nuova = new Localita();
    nuova.setNome(req.nome());
    nuova.setTemperatura(req.temperatura());
    return toResponse(repository.save(nuova));
  }

  @Transactional
  public LocalitaResponse updateCompleto(Long id, LocalitaUpdateRequest req) {
    Localita esistente = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Localita con id=" + id + " non trovata"));

    esistente.setNome(req.nome());
    esistente.setTemperatura(req.temperatura());
    return toResponse(repository.save(esistente));
  }

  @Transactional
  public LocalitaResponse updateParziale(Long id, LocalitaPatchRequest req) {
    Localita esistente = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Localita con id=" + id + " non trovata"));

    if (req.nome() != null) {
      if (req.nome().isBlank()) {
        throw new ResourceNotValidException("Il nome non può essere vuoto");
      }
      esistente.setNome(req.nome());
    }
    if (req.temperatura() != null) {
      esistente.setTemperatura(req.temperatura());
    }

    return toResponse(repository.save(esistente));
  }

  @Transactional
  public void deleteById(Long id) {
    if (!repository.existsById(id)) {
      throw new ResourceNotFoundException("Localita con id=" + id + " non trovata");
    }
    repository.deleteById(id);
  }

  @Transactional
  public long deleteByTemperaturaMinoreDi(Double valore) {
    if (valore == null) throw new ResourceNotValidException("Il valore temperatura non può essere null");
    return repository.deleteByTemperaturaLessThan(valore);
  }

  private LocalitaResponse toResponse(Localita l) {
    return new LocalitaResponse(l.getId(), l.getNome(), l.getTemperatura());
  }
}
