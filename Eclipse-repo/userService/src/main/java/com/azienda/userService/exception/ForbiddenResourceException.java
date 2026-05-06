package com.azienda.userService.exception;

public class ForbiddenResourceException extends RuntimeException{

	public ForbiddenResourceException(String message) {
		super(message);
	}
}
