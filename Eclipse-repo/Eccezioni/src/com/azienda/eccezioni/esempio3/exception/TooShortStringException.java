package com.azienda.eccezioni.esempio3.exception;

public class TooShortStringException extends RuntimeException{

	public TooShortStringException(String message, Throwable cause) {
		super(message, cause);
	}

	
}
