package com.azienda.userService.exception;

public class DuplicateResourceException extends RuntimeException{

	public DuplicateResourceException(String message) {
		super(message);
	}
}
