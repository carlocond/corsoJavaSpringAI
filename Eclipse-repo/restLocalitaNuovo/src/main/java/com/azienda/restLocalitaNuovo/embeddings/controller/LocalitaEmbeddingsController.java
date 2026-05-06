package com.azienda.restLocalitaNuovo.embeddings.controller;

import com.azienda.restLocalitaNuovo.embeddings.dto.SemanticSearchRequest;
import com.azienda.restLocalitaNuovo.embeddings.dto.SemanticSearchResponse;
import com.azienda.restLocalitaNuovo.embeddings.service.LocalitaEmbeddingsService;
import com.azienda.restLocalitaNuovo.dto.LocalitaResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ai/embeddings/localita")
public class LocalitaEmbeddingsController {

  private final LocalitaEmbeddingsService embeddingsService;

  public LocalitaEmbeddingsController(LocalitaEmbeddingsService embeddingsService) {
    this.embeddingsService = embeddingsService;
  }

  /**
   * POST /api/ai/embeddings/localita/reindex
   * Ricrea/aggiorna l'indice vettoriale in memoria.
   */
  @PostMapping("/reindex")
  public ResponseEntity<String> reindex() {
    int indicizzate = embeddingsService.reindexAllLocalita();
    return ResponseEntity.ok("Indicizzate localita: " + indicizzate);
  }

  /**
   * POST /api/ai/embeddings/localita/search
   * body: { "query": "...", "topK": 5 }
   */
  @PostMapping("/search")
  public ResponseEntity<SemanticSearchResponse> search(@Valid @RequestBody SemanticSearchRequest req) {
    int topK = (req.topK() == null || req.topK() <= 0) ? 5 : req.topK();
    List<LocalitaResponse> risultati = embeddingsService.semanticSearch(req.query(), topK);
    return ResponseEntity.ok(new SemanticSearchResponse(req.query(), topK, risultati));
  }
}
