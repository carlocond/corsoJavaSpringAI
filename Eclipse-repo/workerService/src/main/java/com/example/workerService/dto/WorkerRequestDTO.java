package com.example.workerService.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class WorkerRequestDTO {

	@NotBlank(message = "Il campo fName(nome) e' obbligatorio")
	private String fName;
	
	@NotBlank(message = "Il campo lName(cognome) e' obbligatorio")
	private String lName;
	
	@NotNull(message = "Il campo salary e' obbligatorio")
	@DecimalMin(value = "500", message = "Il salario minimo e' 500")
	@DecimalMax(value = "5000", message = "Il salario massimo e' 5000")
	@Digits(integer = 8, fraction = 2, message = "Il formato del salario non e' valido")
	private BigDecimal salary;
	
	
	private Long enterpriseId;
	
	public WorkerRequestDTO() {}

	public WorkerRequestDTO(String fName, String lName, BigDecimal salary, Long enterpriseId) {
		this.fName = fName;
		this.lName = lName;
		this.salary = salary;
		this.enterpriseId = enterpriseId;
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

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	@Override
	public String toString() {
		return "WorkerRequestDTO [fName=" + fName + ", lName=" + lName + ", salary=" + salary + ", enterpriseId="
				+ enterpriseId + "]";
	}
	
	
	
}
