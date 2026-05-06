package com.example.workerService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.workerService.dto.EnterpriseDTOMapper;
import com.example.workerService.dto.EnterpriseRequestDTO;
import com.example.workerService.dto.EnterpriseResponseDTO;
import com.example.workerService.exception.DuplicateResourceException;
import com.example.workerService.exception.ResourceNotFoundException;
import com.example.workerService.model.Enterprise;
import com.example.workerService.repository.EnterpriseRepository;

@Service
@Transactional
public class EnterpriseServiceImpl implements EnterpriseService {
	
	private final EnterpriseRepository repository;
	private final EnterpriseDTOMapper mapper;
	
	public EnterpriseServiceImpl(EnterpriseRepository repository, EnterpriseDTOMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public EnterpriseResponseDTO create(EnterpriseRequestDTO requestDto) {
		if(repository.existsByName(requestDto.getName())) {
			throw new DuplicateResourceException("Azienda con nome: " + requestDto.getName() + " e' gia presente");
		}
		Enterprise e = mapper.toEntity(requestDto);
		repository.save(e);
		
		return mapper.toDto(e);
	}

	@Override
	@Transactional(readOnly = true)
	public List<EnterpriseResponseDTO> getAll() {
		List<Enterprise> list = repository.selectAllWithJoin();
		List<EnterpriseResponseDTO> result = new ArrayList<EnterpriseResponseDTO>();
		
		//Metodo con forEach metodo della lista
		
		//Scorro la lista dei model, la trasformo in responsedto tramite il mapper, inserendo poi il dto nella lista result
		list.forEach(e -> result.add(mapper.toDto(e)));
		
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public EnterpriseResponseDTO getById(Long id) {
		Enterprise e = repository.findById(id)
								.orElseThrow(() -> new ResourceNotFoundException("Azienda con id: " + id + " non trovata"));
		
		return mapper.toDto(e);
	}

	@Override
	public EnterpriseResponseDTO update(Long id, EnterpriseRequestDTO requestDto) {
		Enterprise e = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Azienda con id: " + id + " non trovata"));
		
		if (repository.existsByName(requestDto.getName())) {
			throw new DuplicateResourceException("Nome gia in uso");
		}
		
		e.setName(requestDto.getName());
		return mapper.toDto(e);
	}

	@Override
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Azienda con id: " + id + " non trovata");
		}
		repository.deleteById(id);
	}

}
