package com.example.workerService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.workerService.model.Enterprise;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long>{

	public boolean existsByName(String name);
	
	//Metodo 1
	@Query("SELECT e FROM Enterprise e LEFT JOIN FETCH e.workers")
	public List<Enterprise> selectAllWithJoin();
	
	//Metodo 2
	@EntityGraph(attributePaths = "workers")
	public Optional<Enterprise> findByName(String name);
	
}
