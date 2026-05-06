package com.azienda.restLocalitaNuovo.model;
import jakarta.persistence.*;

@Entity
@Table(name = "localita")
public class Localita {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private Double temperatura;

  public Localita() {}

  public Localita(Long id, String nome, Double temperatura) {
    this.id = id;
    this.nome = nome;
    this.temperatura = temperatura;
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public Double getTemperatura() {
    return temperatura;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setTemperatura(Double temperatura) {
    this.temperatura = temperatura;
  }
}
