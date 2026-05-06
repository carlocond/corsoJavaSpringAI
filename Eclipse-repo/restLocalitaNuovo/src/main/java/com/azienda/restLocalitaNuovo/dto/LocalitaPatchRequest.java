package com.azienda.restLocalitaNuovo.dto;

//se null non vengono modificati
public record LocalitaPatchRequest(
	    String nome,
	    Double temperatura
	) {}