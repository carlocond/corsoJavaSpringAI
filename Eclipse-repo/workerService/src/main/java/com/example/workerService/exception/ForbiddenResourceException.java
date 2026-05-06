package com.example.workerService.exception;

public class ForbiddenResourceException extends RuntimeException{
	//unchecked
	public ForbiddenResourceException(String message) {
		super(message);
	} 
	
	

}
