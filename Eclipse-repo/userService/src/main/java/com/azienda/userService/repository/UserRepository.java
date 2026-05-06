package com.azienda.userService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.azienda.userService.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public boolean existsByUsername(String username);
	public Optional<User> findByUsername(String username);
	public boolean existsByEmail(String email);
	public Optional<User> findByEmail(String email);
	@Query("""
			SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.roles r
			LEFT JOIN FETCH r.permissions WHERE u.username = :usr
			""")
	public Optional<User> selectByUsername(@Param("usr") String username);
	@Query("""
			SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.roles r
			LEFT JOIN FETCH r.permissions WHERE u.email = :email
			""")
	public Optional<User> selectByEmail(@Param("email") String email);
}
