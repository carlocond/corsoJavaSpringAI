package com.example.workerService.dto;

import org.springframework.stereotype.Component;

import com.example.workerService.model.Worker;

@Component
public class WorkerDTOMapper {

	public Worker toEntity(WorkerRequestDTO requestDto) {
		return new Worker(requestDto.getfName(), requestDto.getlName(), requestDto.getSalary());
	}
	
	public WorkerResponseDTO toDto(Worker worker) {
		return new WorkerResponseDTO(worker.getId(),
									worker.getfName(),
									worker.getlName(),
									worker.getSalary(),
									worker.getCreatedAt(),
									worker.getUpdatedAt(),
									worker.getEnterprise().getName());
	}
}
