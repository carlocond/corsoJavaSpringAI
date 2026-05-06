package com.azienda.userService.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequestDto {

	@NotBlank(message = "Username obbligatorio")
	private String username;
	
	@NotBlank(message = "password obbligatoria")
	private String password;
	
	public LoginRequestDto() {}

	public LoginRequestDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
