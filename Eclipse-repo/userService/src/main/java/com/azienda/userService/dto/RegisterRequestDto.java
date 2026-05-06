package com.azienda.userService.dto;

import jakarta.validation.constraints.NotBlank;

public class RegisterRequestDto {

	@NotBlank(message="Il campo Username è obbligatorio")
	private String username;
	
	@NotBlank(message="il campo Email è obbligatorio")
	private String email;
	
	@NotBlank(message="il campo Password è obbligatorio")
	private String password;
	
	public RegisterRequestDto() {}
	
	public RegisterRequestDto(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
