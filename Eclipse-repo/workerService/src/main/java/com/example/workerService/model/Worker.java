package com.example.workerService.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "worker", indexes = {@Index(name = "idx_worker_salary", columnList = "salary"),
									@Index(name = "idx_worker_enterprise", columnList = "enterprise_id")})
public class Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String fName;
	
	@Column(nullable = false, length = 50)
	private String lName;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal salary;
	
	@ManyToOne(fetch = FetchType.LAZY) //permette di scegliere di fare le join, a differenza di EAGER, che le fa in automatico
	@JoinColumn(name = "enterprise_id")
	private Enterprise enterprise;
	
	@Column(nullable = false, name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(nullable = false, name = "updated_at")
	private LocalDateTime updatedAt;
	
	public Worker() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = createdAt;
	}
	
	public Worker(String fName, String lName, BigDecimal salary) {
		this();
		this.fName = fName;
		this.lName = lName;
		this.salary = salary;
	}
	
	@PreUpdate
	public void preUpdate() {
		updatedAt = LocalDateTime.now();
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

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
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

	@Override
	public String toString() {
		return "Worker [id=" + id + ", fName=" + fName + ", lName=" + lName + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fName, lName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		return Objects.equals(fName, other.fName) && Objects.equals(lName, other.lName);
	}
	
	
	
}
