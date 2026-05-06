package com.azienda.esercizioRestClient.dto;

import jakarta.validation.constraints.NotNull;

public class TemperaturaDto {

	@NotNull(message = "Il valore della temperatura è obbligatorio")
  private Double valore;

  public TemperaturaDto() {}

  public TemperaturaDto(Double valore) {
    this.valore = valore;
  }

  public Double getValore() {
    return valore;
  }

  public void setValore(Double valore) {
    this.valore = valore;
  }
}
