package com.azienda.restClient2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.azienda.restClient2.model.Localita;

public interface LocalitaRepository extends JpaRepository<Localita, Integer>{

	@Query("insert into LocalitaBean x (nome,temperatura) values(?1,?2)")
	public Localita saveByNomeAndTemperatura(String nome,Float temperatura);
	
	@Query("UPDATE LocalitaBean x SET x.temperatura= :temperatura WHERE x.id= :id")
	public void updateByIdNewTemperatura(@Param("id") Integer id,@Param("temperatura") Float temperatura);
	
	public Boolean existsByNome(String nome);
	
	public List<Localita> findByNome(String nome);
	
	public List<Localita> findByTemperaturaLessThanEqual(Float maxTemperatura);
	
	public List<Localita> findByTemperaturaGreaterThanEqual(Float minTemperatura);
	
	//@Query("select x from LocalitaBean x where x.nome like '%?1%'")
	public List<Localita> findByNomeContaining(String keyword);
	
	@Query("select distinct x from Localita x where x.nome=?1")
	public Localita selectByNome(String nome);
}
