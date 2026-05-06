package com.azienda.esercizioRestClient.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LocalitaDto {

  private Integer id;

  @NotBlank
  private String citta;

  @NotNull
  private Double temperatura;

  public LocalitaDto() {}

  public LocalitaDto(Integer id, String citta, Double temperatura) {
    this.id = id;
    this.citta = citta;
    this.temperatura = temperatura;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCitta() {
    return citta;
  }

  public void setCitta(String citta) {
    this.citta = citta;
  }

  public Double getTemperatura() {
    return temperatura;
  }

  public void setTemperatura(Double temperatura) {
    this.temperatura = temperatura;
  }
}
