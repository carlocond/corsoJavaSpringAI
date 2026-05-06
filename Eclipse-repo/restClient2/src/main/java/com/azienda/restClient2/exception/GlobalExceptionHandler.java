package com.azienda.restClient2.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String,String> handleConstraintViolationException(ConstraintViolationException e){
		Map<String,String> result = new HashMap<String, String>();
		e.getConstraintViolations().forEach( ce -> {
			result.put(ce.getPropertyPath().toString(),ce.getMessage());
		});
		return result;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String,String> handleMethodArgumentException(MethodArgumentNotValidException e){
		Map<String,String> result = new HashMap<String, String>();
		e.getBindingResult().getFieldErrors().forEach( oe -> {
			result.put(oe.getField(),oe.getDefaultMessage());
		});
		return result;
	}
}