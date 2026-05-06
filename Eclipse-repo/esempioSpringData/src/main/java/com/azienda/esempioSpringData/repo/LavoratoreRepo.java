package com.azienda.esempioSpringData.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.azienda.esempioSpringData.model.Lavoratore;

public interface LavoratoreRepo extends JpaRepository<Lavoratore, Integer>{
	
	//Prima tecnica
	public List<Lavoratore> findByStipendioBetween(Float stipendioStart, Float stipendioEnd);
	
	//Seconda tecnica JPQL
	@Query("SELECT x FROM Lavoratore x WHERE x.matricola BETWEEN :par1 AND :par2")
	public List<Lavoratore> searchByMatricolaBetween(@Param("par1") Integer matrStart, @Param("par2") Integer matrEnd);
	

}
