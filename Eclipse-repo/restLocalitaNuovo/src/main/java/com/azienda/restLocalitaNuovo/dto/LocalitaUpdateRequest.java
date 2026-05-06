package com.azienda.restLocalitaNuovo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LocalitaUpdateRequest(
    @NotBlank String nome,
    @NotNull Double temperatura
) {}
