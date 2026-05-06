package com.azienda.esercizioRestClient.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleNotFound(ResourceNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(Map.of("error", "Risorsa_Non_Trovata", "message", e.getMessage()));
	}
	
	@ExceptionHandler(ResourceNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleNotValid(ResourceNotValidException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Risorsa_Non_Valida", "message", e.getMessage()));
	}
	
}
