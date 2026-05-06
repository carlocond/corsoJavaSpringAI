package com.azienda.gateway.utils;

import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

	@Value("${jwt.secret}")
	private String secret;
	@Value("${jwt.expiration}")
	private Long expiration;
	
	//serve per la validazione e l'estrazione dei claims
	public Claims extractAllClaims(String token) {
		SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
		return Jwts.parser()
				.verifyWith(key)
				.build()
				.parseSignedClaims(token)
				.getPayload();
	}
	
	public String extractUsername(String token) {
		return extractAllClaims(token)
				.get("username", String.class);
	}
	
	public Long extractUserId(String token) {
		return extractAllClaims(token)
				.get("userId", Long.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> extractRoles(String token){
		return extractAllClaims(token)
				.get("roles", List.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> extractPermission(String token){
		return extractAllClaims(token)
				.get("permissions", List.class);
	}
	
	
	
	
}
