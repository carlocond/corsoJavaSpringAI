package com.azienda.restLocalitaNuovo.embeddings.service;

import com.azienda.restLocalitaNuovo.dto.LocalitaResponse;
import com.azienda.restLocalitaNuovo.embeddings.dto.SemanticSearchRequest;
import com.azienda.restLocalitaNuovo.service.LocalitaService;
import com.openai.models.vectorstores.VectorStore;

import org.springframework.ai.document.Document;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LocalitaEmbeddingsService {

  private final VectorStore vectorStore;
  private final LocalitaService localitaService;

  public LocalitaEmbeddingsService(VectorStore vectorStore, LocalitaService localitaService) {
    this.vectorStore = vectorStore;
    this.localitaService = localitaService;
  }

  /**
   * Ricrea l'indice vettoriale partendo dalle località su MySQL.
   * Semplice ma efficace per esercizio.
   */
  public int reindexAllLocalita() {
    List<LocalitaResponse> all = localitaService.getAll();

    // Pulizia: SimpleVectorStore non ha sempre clear() in tutte le versioni,
    // quindi approccio semplice: ricreo i documenti e li aggiungo. Se hai duplicati,
    // puoi cambiare strategia (es: usare docId fisso).
    List<Document> docs = all.stream()
        .map(this::toDocument)
        .toList();

    vectorStore.add(docs);
    return docs.size();
  }

  public List<LocalitaResponse> semanticSearch(String query, int topK) {
    // SearchRequest permette similarity search sul VectorStore
    List<Document> docs = vectorStore.similaritySearch(
        SemanticSearchRequest.query(query).withTopK(topK)
    );

    // estraggo localitaId dai metadata
    List<Long> ids = docs.stream()
        .map(d -> d.getMetadata().get("localitaId"))
        .filter(Objects::nonNull)
        .map(Object::toString)
        .map(Long::valueOf)
        .distinct()
        .toList();

    // converto in LocalitaResponse, preservando l'ordine "più simile prima"
    Map<Long, LocalitaResponse> byId = new HashMap<>();
    for (Long id : ids) {
      byId.put(id, localitaService.getById(id));
    }

    return ids.stream()
        .map(byId::get)
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
  }

  private Document toDocument(LocalitaResponse l) {
    // Testo “ricercabile”: qui ci mettiamo info utili.
    // Puoi arricchirlo se vuoi migliorare la semantica.
    String content = "Localita: " + l.nome() + ". Temperatura: " + l.temperatura();

    Map<String, Object> meta = new HashMap<>();
    meta.put("localitaId", l.id());
    meta.put("nome", l.nome());

    // Document(content, metadata)
    return new Document(content, meta);
  }
}
