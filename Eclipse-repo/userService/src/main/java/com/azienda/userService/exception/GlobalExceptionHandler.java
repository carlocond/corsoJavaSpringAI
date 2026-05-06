package com.azienda.userService.exception;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ProblemDetail handleResourceNotFound(
			ResourceNotFoundException ex, HttpServletRequest request) {
		ProblemDetail pd = ProblemDetail.forStatusAndDetail(
				HttpStatus.NOT_FOUND, ex.getMessage());
		pd.setTitle("Not Found");
		pd.setInstance(URI.create(request.getRequestURI()));
		return pd;
	}

	@ExceptionHandler(DuplicateResourceException.class)
	public ProblemDetail handleDuplicateResource(
			DuplicateResourceException ex, HttpServletRequest request) {
		ProblemDetail pd = ProblemDetail.forStatusAndDetail(
				HttpStatus.CONFLICT, ex.getMessage());
		pd.setTitle("Conflict");
		pd.setInstance(URI.create(request.getRequestURI()));
		return pd;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ProblemDetail handleValidationErrors(
			MethodArgumentNotValidException ex, HttpServletRequest request) {
		ProblemDetail pd = ProblemDetail.forStatusAndDetail(
				HttpStatus.BAD_REQUEST, "Validation failed");
		pd.setTitle("Validation Error");
		pd.setInstance(URI.create(request.getRequestURI()));

		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(f -> f.getField() + ": " + f.getDefaultMessage())
				.toList();
		pd.setProperty("errors", errors);
		return pd;
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ProblemDetail handleConstraintViolationException(ConstraintViolationException e, HttpServletRequest request){
		ProblemDetail pd = ProblemDetail.forStatusAndDetail(
				HttpStatus.BAD_REQUEST, "Validation failed");
		pd.setTitle("Validation Error");
		pd.setInstance(URI.create(request.getRequestURI()));
		List<String> errors = new ArrayList<String>();
		e.getConstraintViolations().forEach( ce -> {
			errors.add(ce.getPropertyPath().toString()+" : "+ce.getMessage());
		});
		pd.setProperty("errors", errors );
		return pd;
	}
	
	@ExceptionHandler(ForbiddenResourceException.class)
	public ProblemDetail handleForbiddenResource(
			ForbiddenResourceException ex, HttpServletRequest request) {
		ProblemDetail pd = ProblemDetail.forStatusAndDetail(
				HttpStatus.FORBIDDEN , ex.getMessage());
		pd.setTitle("Forbidden");
		pd.setInstance(URI.create(request.getRequestURI()));
		return pd;
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ProblemDetail handleAccessDeniedException(
			AccessDeniedException ex, HttpServletRequest request) {
		ProblemDetail pd = ProblemDetail.forStatusAndDetail(
				HttpStatus.FORBIDDEN , ex.getMessage());
		pd.setTitle("Forbidden");
		pd.setInstance(URI.create(request.getRequestURI()));
		return pd;
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ProblemDetail handleBadCredentialsExceptionException(
			BadCredentialsException ex, HttpServletRequest request) {
		ProblemDetail pd = ProblemDetail.forStatusAndDetail(
				HttpStatus.UNAUTHORIZED , ex.getMessage());
		pd.setTitle("Unauthorized");
		pd.setInstance(URI.create(request.getRequestURI()));
		return pd;
	}
	
	@ExceptionHandler(Exception.class)
	public ProblemDetail handleGenericException(
			Exception ex, HttpServletRequest request) {
		ProblemDetail pd = ProblemDetail.forStatusAndDetail(
				HttpStatus.INTERNAL_SERVER_ERROR , "Errore imprevisto");
		pd.setTitle("Internal_server_error");
		pd.setInstance(URI.create(request.getRequestURI()));
		return pd;
	}
}
