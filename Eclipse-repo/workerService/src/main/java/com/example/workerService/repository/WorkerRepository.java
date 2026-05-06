package com.example.workerService.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.workerService.model.Enterprise;
import com.example.workerService.model.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

	//Si collega al concetto di aver usato fecthtype lazy
	@Query("SELECT w FROM Worker w LEFT JOIN FETCH w.enterprise")
	public List<Worker> selectAll();
	
	@EntityGraph(attributePaths = "enterprise")
	public List<Worker> findByEnterprise(String name);
	
	@EntityGraph(attributePaths = "enterprise")
	public List<Worker> findBySalaryBetween(BigDecimal min, BigDecimal max);
	
	@EntityGraph(attributePaths = "workers")
	public Optional<Enterprise> findByName(String name);
	
	public boolean existsByNameAndSurname(String fName, String lName);
	
}