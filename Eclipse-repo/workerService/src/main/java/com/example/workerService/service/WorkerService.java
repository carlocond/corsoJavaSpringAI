package com.example.workerService.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.workerService.dto.WorkerRequestDTO;
import com.example.workerService.dto.WorkerResponseDTO;

public interface WorkerService {

	public WorkerResponseDTO create(WorkerRequestDTO requestDto);
	public List<WorkerResponseDTO> getAll();
	public WorkerResponseDTO getById(Long id);
	public WorkerResponseDTO update(Long id, WorkerRequestDTO requestDto);
	public void delete(Long id);
	public List<WorkerResponseDTO> getByEnterprise(String enterpriseName);
	public List<WorkerResponseDTO> getBySalaryBetween(BigDecimal min, BigDecimal max);
	
}
