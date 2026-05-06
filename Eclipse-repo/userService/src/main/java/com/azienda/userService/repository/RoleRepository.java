package com.azienda.userService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azienda.userService.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	public boolean existsByName(String name);
	public Optional<Role> findByName(String name);
	
}
