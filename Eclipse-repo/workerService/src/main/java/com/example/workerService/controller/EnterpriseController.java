package com.example.workerService.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workerService.dto.EnterpriseRequestDTO;
import com.example.workerService.dto.EnterpriseResponseDTO;
import com.example.workerService.service.EnterpriseService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping(path = "/api/enterprises", produces = "application/json")
@CrossOrigin(origins = "*") // oppure solo "*"
@Validated
public class EnterpriseController {
	
	private final EnterpriseService service;
	
	public EnterpriseController(EnterpriseService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<EnterpriseResponseDTO> create(@Valid @RequestBody EnterpriseRequestDTO requestDto) {
		EnterpriseResponseDTO response = service.create(requestDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response); //CODICE 201 HTTP
	}
	
	@GetMapping
	public ResponseEntity<List<EnterpriseResponseDTO>> getAll(){
		List<EnterpriseResponseDTO> result = service.getAll();
		
		return ResponseEntity.ok(result); //CODICE 200 HTTP
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EnterpriseResponseDTO> getById(@Positive(message = "Il valore deve essere > 0") @PathVariable("id") Long id) {
		return ResponseEntity.ok(service.getById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EnterpriseResponseDTO> update(@Positive(message = "Il valore deve essere > 0") @PathVariable("id") Long id,
																@Valid @RequestBody EnterpriseRequestDTO requestDto){
		EnterpriseResponseDTO response = service.update(id, requestDto);
		
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@Positive(message = "Il valore deve essere > 0") @PathVariable("id") Long id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}
