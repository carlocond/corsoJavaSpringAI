package com.azienda.restLocalitaNuovo.controller;

import com.azienda.restLocalitaNuovo.dto.*;
import com.azienda.restLocalitaNuovo.service.LocalitaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/localita")
public class LocalitaController {

  private final LocalitaService service;

  public LocalitaController(LocalitaService service) {
    this.service = service;
  }

  @GetMapping
  public List<LocalitaResponse> getAll() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public LocalitaResponse getById(@PathVariable Long id) {
    return service.getById(id);
  }

  @GetMapping("/nome/{nome}")
  public LocalitaResponse getByNome(@PathVariable String nome) {
    return service.getByNome(nome);
  }

  @PostMapping
  public ResponseEntity<LocalitaResponse> create(@Valid @RequestBody LocalitaCreateRequest req) {
    return ResponseEntity.ok(service.create(req));
  }

  @PutMapping("/{id}")
  public ResponseEntity<LocalitaResponse> updateCompleto(
      @PathVariable Long id,
      @Valid @RequestBody LocalitaUpdateRequest req
  ) {
    return ResponseEntity.ok(service.updateCompleto(id, req));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<LocalitaResponse> updateParziale(
      @PathVariable Long id,
      @RequestBody LocalitaPatchRequest req
  ) {
    return ResponseEntity.ok(service.updateParziale(id, req));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Long id) {
    service.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/temperatura/minore/{valore}")
  public ResponseEntity<String> deleteByTempMinore(@PathVariable Double valore) {
    long deleted = service.deleteByTemperaturaMinoreDi(valore);
    return ResponseEntity.ok("Localita eliminate: " + deleted);
  }
}