package com.example.workerService.dto;

import org.springframework.stereotype.Component;

import com.example.workerService.model.Enterprise;

@Component
public class EnterpriseDTOMapper {
//Classe che permette le conversioni tra dto e ed entity
//dalla ui arriva al dto, tira fuori l'oggetto e lo salva in database, e viceversa, tramite request e response
	
	//Ci sono due metodi di conversione bidirezionale
	
	
	public Enterprise toEntity(EnterpriseRequestDTO requestDto) {
		return new Enterprise(requestDto.getName());
	}
	
	public EnterpriseResponseDTO toDto(Enterprise enterprise) {
		return new EnterpriseResponseDTO(enterprise.getId(), enterprise.getName(), enterprise.getCreatedAt(), enterprise.getUpdatedAt());
	}

}
