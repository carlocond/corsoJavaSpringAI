package com.azienda.restLocalitaNuovo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LocalitaCreateRequest(
    @NotBlank String nome,
    @NotNull Double temperatura
) {}
