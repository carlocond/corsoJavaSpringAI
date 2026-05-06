package com.example.workerService.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.workerService.dto.EnterpriseRequestDTO;
import com.example.workerService.dto.EnterpriseResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Enterprises", description = "Enterprises management APIs")
public interface EnterpriseControllerOpenApi {
	
	/**
	* Create a new enterprise
	* POST /api/enterprises
	*/
	@Operation(
			summary = "Create a new enterprise",
			description = "Creates a new enterprise with the provided information"
			)
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "201",
					description = "Enterprise created successfully",
					content = @Content(schema = @Schema(implementation = EnterpriseRequestDTO.class))
					),
			@ApiResponse(
					responseCode = "400",
					description = "Invalid input - validation failed"
					),
			@ApiResponse(
					responseCode = "409",
					description = "Enterprise with this name already exists"
					)
	})
	
	public ResponseEntity<EnterpriseResponseDTO> create(@Valid @RequestBody EnterpriseRequestDTO requestDto);
	public ResponseEntity<List<EnterpriseResponseDTO>> getAll();
	public ResponseEntity<EnterpriseResponseDTO> getById(Long id);
	public ResponseEntity<EnterpriseResponseDTO> update(Long id,EnterpriseRequestDTO requestDto);
	public ResponseEntity<Void> delete(Long id);
	
}