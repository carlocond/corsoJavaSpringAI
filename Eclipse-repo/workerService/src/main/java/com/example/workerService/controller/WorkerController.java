package com.example.workerService.controller;

import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.workerService.dto.WorkerRequestDTO;
import com.example.workerService.dto.WorkerResponseDTO;
import com.example.workerService.service.WorkerService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/api/workers")
@CrossOrigin("*")
@Validated
public class WorkerController {

	private final WorkerService service;

	public WorkerController(WorkerService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<WorkerResponseDTO> create(@Valid @RequestBody WorkerRequestDTO request){
		
		WorkerResponseDTO response = service.create(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
	
	@GetMapping
	public ResponseEntity<List<WorkerResponseDTO>> getAll(){
		List<WorkerResponseDTO> response = service.getAll();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<WorkerResponseDTO> getById(@Positive(message = "l'id deve essere positivo") @PathVariable("id") Long id){
		return ResponseEntity.ok(service.getById(id));
	}
	@GetMapping("/enterprise/{name}")
	public ResponseEntity<List<WorkerResponseDTO>> getByEnterprise(@NotBlank(message="Il nome dell'azienda è obbligatorio") @PathVariable("name") String name){
		
		List<WorkerResponseDTO> responseDto = service.getByEnterprise(name);
		return ResponseEntity.ok(responseDto);

	}
	
	@GetMapping("/salary-range")
	public ResponseEntity<List<WorkerResponseDTO>> getBySalary(
			@DecimalMin(value = "500" , message="il salario minimo è 500") @RequestParam BigDecimal min, 
			@DecimalMax(value = "5000" , message="il salario massimo è 5000") @RequestParam  BigDecimal max
			){
		List<WorkerResponseDTO> response = service.getBySalaryBetween(min, max);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<WorkerResponseDTO> update(@Positive(message = "l'id deve essere positivo") @PathVariable("id") Long id, 
			@Valid @RequestBody WorkerRequestDTO requestDto){
		
		WorkerResponseDTO responseDto = service.update(id, requestDto);
		return ResponseEntity.ok(responseDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@Positive(message = "l'id deve essere positivo") @PathVariable("id") Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
