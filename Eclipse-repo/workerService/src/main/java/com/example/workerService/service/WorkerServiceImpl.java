package com.example.workerService.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.workerService.dto.WorkerDTOMapper;
import com.example.workerService.dto.WorkerRequestDTO;
import com.example.workerService.dto.WorkerResponseDTO;
import com.example.workerService.exception.DuplicateResourceException;
import com.example.workerService.exception.ResourceNotFoundException;
import com.example.workerService.model.Enterprise;
import com.example.workerService.model.Worker;
import com.example.workerService.repository.EnterpriseRepository;
import com.example.workerService.repository.WorkerRepository;

@Service
@Transactional
public class WorkerServiceImpl implements WorkerService{
	
	private final WorkerRepository workerRepository;
	private final EnterpriseRepository enterpriseRepository;
	private final WorkerDTOMapper mapper;

	public WorkerServiceImpl(WorkerRepository workerRepository, EnterpriseRepository enterpriseRepository,
			WorkerDTOMapper mapper) {
		this.workerRepository = workerRepository;
		this.enterpriseRepository = enterpriseRepository;
		this.mapper = mapper;
	}

	@Override
	public WorkerResponseDTO create(WorkerRequestDTO requestDto) {
		Enterprise e = enterpriseRepository.findById(requestDto.getEnterpriseId())
				.orElseThrow(() -> new ResourceNotFoundException("Azienda con id: " + requestDto.getEnterpriseId() + " non trovata"));
		
		if (workerRepository.existsByNameAndSurname(requestDto.getfName(), requestDto.getlName())) {
			throw new DuplicateResourceException("Lavoratore " + requestDto.getfName() + " " + requestDto.getlName() + " e' gia presente");
		}
		
		Worker w = mapper.toEntity(requestDto);
		w.setEnterprise(e);
		
		workerRepository.save(w);
		
		return mapper.toDto(w);
	}

	@Override
	@Transactional(readOnly = true)
	public List<WorkerResponseDTO> getAll() {
		List<Worker> workers = workerRepository.selectAll();
		List<WorkerResponseDTO> result = new ArrayList<WorkerResponseDTO>();
		
		//metodo con for enhanced
		for (Worker w : workers) {
			WorkerResponseDTO responseDto = mapper.toDto(w);
			result.add(responseDto);
		}
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public WorkerResponseDTO getById(Long id) {
		Worker w = workerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Lavoratore con id: " + id + " non trovato"));
		
		return mapper.toDto(w);
	}

	@Override
	@Transactional(readOnly = true)
	public List<WorkerResponseDTO> getByEnterprise(String enterpriseName) {
		if(!enterpriseRepository.existsByName(enterpriseName)) {
			throw new ResourceNotFoundException("Azienda con nome: " + enterpriseName + " non trovata");
		}
		
		List<Worker> workers = workerRepository.findByEnterprise(enterpriseName);
		List<WorkerResponseDTO> result = new ArrayList<WorkerResponseDTO>();
		
		for (Worker w : workers) {
			WorkerResponseDTO responseDto = mapper.toDto(w);
			result.add(responseDto);
		}
		return result;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<WorkerResponseDTO> getBySalaryBetween(BigDecimal min, BigDecimal max) {
		List<Worker> workers = workerRepository.findBySalaryBetween(min, max);
		
		List<WorkerResponseDTO> result = new ArrayList<WorkerResponseDTO>();
		
		for (Worker w : workers) {
			WorkerResponseDTO responseDto = mapper.toDto(w);
			result.add(responseDto);
		}
		return result;
	}

	@Override
	public WorkerResponseDTO update(Long id, WorkerRequestDTO requestDto) {
		Worker w = workerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Lavoratore con id: " + id + " non trovato"));
		
		w.setfName(requestDto.getfName());
		w.setlName(requestDto.getlName());
		w.setSalary(requestDto.getSalary());
		
		if (requestDto.getEnterpriseId() != null) {
			Enterprise e = enterpriseRepository.findById(requestDto.getEnterpriseId())
					.orElseThrow(() -> new ResourceNotFoundException("Azienda con id: " + requestDto.getEnterpriseId() + " non trovata"));
			
			w.setEnterprise(e);
		}
		
		return mapper.toDto(w);
	}

	@Override
	public void delete(Long id) {
		if (!workerRepository.existsById(id)) {
			throw new ResourceNotFoundException("Lavoratore con id: " + id + " non trovato");
		}
		
		workerRepository.deleteById(id);
	}


}
