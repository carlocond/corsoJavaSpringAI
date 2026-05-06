package com.example.workerService.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WorkerResponseDTO {

	private Long id;
	private String fName;
	private String lName;
	private BigDecimal salary;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String enterpriseName;
	
	
	public WorkerResponseDTO() {}

	public WorkerResponseDTO(Long id, String fName, String lName, BigDecimal salary, LocalDateTime createdAt,
			LocalDateTime updatedAt, String enterpriseName) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.salary = salary;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.enterpriseName = enterpriseName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	@Override
	public String toString() {
		return "WorkerResponseDTO [id=" + id + ", fName=" + fName + ", lName=" + lName + ", salary=" + salary
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", enterpriseName=" + enterpriseName + "]";
	}
}
