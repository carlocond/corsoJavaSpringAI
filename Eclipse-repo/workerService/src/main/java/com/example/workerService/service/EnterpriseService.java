package com.example.workerService.service;

import java.util.List;

import com.example.workerService.dto.EnterpriseRequestDTO;
import com.example.workerService.dto.EnterpriseResponseDTO;

public interface EnterpriseService {

	public EnterpriseResponseDTO create(EnterpriseRequestDTO requestDto);
	public List<EnterpriseResponseDTO> getAll();
	public EnterpriseResponseDTO getById(Long id);
	public EnterpriseResponseDTO update(Long id, EnterpriseRequestDTO requestDto);
	public void delete(Long id);
	
}
