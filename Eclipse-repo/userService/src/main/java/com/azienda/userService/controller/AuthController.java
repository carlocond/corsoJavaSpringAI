package com.azienda.userService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azienda.userService.dto.LoginRequestDto;
import com.azienda.userService.dto.LoginResponseDto;
import com.azienda.userService.dto.RegisterRequestDto;
import com.azienda.userService.dto.RegisterResponseDto;
import com.azienda.userService.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
@Validated
public class AuthController {

	private final AuthService authService;

	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto requestDto){
		return ResponseEntity.ok(authService.login(requestDto));
	}
	
	@PreAuthorize("hasAuthority('user.read')")
	@GetMapping("/ciao")
	public String ciao() {
		return "ciao";
	}
	@PreAuthorize("hasAuthority('user.write')")
	@GetMapping("/ciao2")
	public String ciao2() {
		return "ciao2";
	}
	
	@PostMapping("/register")
	public ResponseEntity<RegisterResponseDto> register(@Valid @RequestBody RegisterRequestDto requestDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(requestDto));
	}
}
