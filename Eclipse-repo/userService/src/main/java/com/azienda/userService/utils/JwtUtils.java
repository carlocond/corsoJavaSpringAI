package com.azienda.userService.utils;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.azienda.userService.model.Permission;
import com.azienda.userService.model.Role;
import com.azienda.userService.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

	@Value("${jwt.secret}")
	private String secret;
	@Value("${jwt.expiration}")
	private Long expiration;

	//mi servirà dopo una login con successo
	public String generateToken(User user) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("userId", user.getId());
		claims.put("username", user.getUsername());
		claims.put("email", user.getEmail());

		List<String> roles = user.getRoles().stream().map(Role::getName).toList();

		claims.put("roles", roles);

		List<String> permissions = user.getRoles().stream()
				.flatMap(role -> role.getPermissions().stream())
				.map(Permission::getName)
				.distinct()
				.toList();

		claims.put("permissions", permissions);

		//modo che chiede oauth2 ed è il modo standard
		claims.put("scope", String.join(", ", permissions));

		Date now = new Date();

		//scadenza del token, da adesso a 24ore(tempo impostato nell'expiration)
		Date expirationDate = new Date(now.getTime() + expiration);

		//crea l'oggetto per firmare il token -> secret.getBytes(StandardCharsets.UTF_8)
		SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

		//creazione token
		return Jwts.builder()
				.claims(claims)
				.subject(user.getEmail())
				.issuedAt(now)
				.expiration(expirationDate)
				.signWith(key)
				.compact();
	}
	
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
