package com.azienda.restLocalitaNuovo.embeddings.dto;

import com.azienda.restLocalitaNuovo.dto.LocalitaResponse;

import java.util.List;

public record SemanticSearchResponse(
    String query,
    int topK,
    List<LocalitaResponse> risultati
) {}
