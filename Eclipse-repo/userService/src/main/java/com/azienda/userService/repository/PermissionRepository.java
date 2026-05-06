package com.azienda.userService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azienda.userService.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long>{

	public boolean existsByName(String name);
	public Optional<Permission> findByName(String name);
}
