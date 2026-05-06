package com.azienda.restClient2.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LocalitaDto {

	@NotNull(message = "Id non può essere null")
	@Min(value=0,message = "L'id deve valere almeno 0")
	private Integer id;
	
	@NotNull(message = "Il nome non può essere NULL")
	@NotBlank(message = "Il nome è obbligatorio")
	private String nome;
	
	@NotNull(message = "La temperatura non può essere NULL")
	@Min(value = -40l,message = "La temperatura deve essere maggiore di -40")
	@Max(value = 55l,message = "La temperatura deve essere minore di 55")
	private Float temperatura;
	
	public LocalitaDto() {	}
	
	

	public LocalitaDto(Integer id, String nome, Float temperatura) {
		super();
		this.id = id;
		this.nome = nome;
		this.temperatura = temperatura;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Float temperatura) {
		this.temperatura = temperatura;
	}

	@Override
	public String toString() {
		return "Localita [id=" + id + ", nome=" + nome + ", temperatura=" + temperatura + "]";
	}
	
}
