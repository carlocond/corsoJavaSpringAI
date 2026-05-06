package com.example.workerService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EnterpriseRequestDTO {

	@NotBlank(message = "Il campo 'name' non va lasciato vuoto")
	@Size(min = 3, max = 50, message = "Il nome dell'azienda deve essere compreso tra 3 e 50 caratteri")
	private String name;
	
	public EnterpriseRequestDTO() {}
	
	public EnterpriseRequestDTO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EnterpriseRequestDTO [name=" + name + "]";
	}
	
	
	
}
