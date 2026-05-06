package com.azienda.restLocalitaNuovo.embeddings.dto;

import jakarta.validation.constraints.NotBlank;

public record SemanticSearchRequest(
    @NotBlank String query,
    Integer topK
) {}
