package com.azienda.userService.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.azienda.userService.dto.LoginRequestDto;
import com.azienda.userService.dto.LoginResponseDto;
import com.azienda.userService.dto.RegisterRequestDto;
import com.azienda.userService.dto.RegisterResponseDto;
import com.azienda.userService.exception.DuplicateResourceException;
import com.azienda.userService.exception.ForbiddenResourceException;
import com.azienda.userService.exception.ResourceNotFoundException;
import com.azienda.userService.model.Permission;
import com.azienda.userService.model.Role;
import com.azienda.userService.model.User;
import com.azienda.userService.repository.PermissionRepository;
import com.azienda.userService.repository.RoleRepository;
import com.azienda.userService.repository.UserRepository;
import com.azienda.userService.utils.JwtUtils;
import com.azienda.userService.utils.PermissionNames;
import com.azienda.userService.utils.SecurityUtils;



@Service
@Transactional
public class AuthService {

	private final AuthenticationManager authenticationManager;
	private final UserRepository userRepository;
	private final JwtUtils jwtUtils;
	private final RoleRepository roleRepository;
	private final PermissionRepository permissionRepository;
	private final PasswordEncoder passwordEncoder;


	public AuthService(AuthenticationManager authenticationManager, UserRepository userRepository, JwtUtils jwtUtils,
			RoleRepository roleRepository, PermissionRepository permissionRepository, PasswordEncoder passwordEncoder) {
		super();
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.jwtUtils = jwtUtils;
		this.roleRepository = roleRepository;
		this.permissionRepository = permissionRepository;
		this.passwordEncoder = passwordEncoder;
	}


	public LoginResponseDto login(LoginRequestDto requestDto) {

		Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				requestDto.getUsername()
				,requestDto.getPassword()));

		String email = auth.getName();

		User user = userRepository.selectByEmail(email).orElseGet(() -> userRepository.selectByUsername(email)
				.orElseThrow(()-> new UsernameNotFoundException("Username non trovata"))
				);

		String token = jwtUtils.generateToken(user);

		return new LoginResponseDto(token);
	}
	
	public RegisterResponseDto register(RegisterRequestDto requestDto) {
		
		if(!SecurityUtils.hasPermission(PermissionNames.USER_WRITE)) {
			throw new ForbiddenResourceException("L'utente non ha i permessi per registrare");
		}
		
		if(userRepository.existsByUsername(requestDto.getUsername()) || 
				userRepository.existsByEmail(requestDto.getEmail())) {
			throw new DuplicateResourceException("Utente già esistente");
		}
		
		User user = new User(requestDto.getUsername(),passwordEncoder.encode(requestDto.getPassword()), requestDto.getEmail());
		Role role = roleRepository.findByName("USER").orElseThrow(() -> new ResourceNotFoundException("Il ruolo user non esiste"));
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRoles(roles);
		userRepository.save(user);
		
		return new RegisterResponseDto(user.getId(),user.getUsername(),user.getEmail());
	
	}

	
	
	
	public void init() {
		Permission userRead = new Permission(PermissionNames.USER_READ, "View users", "user", "read");
		Permission userWrite = new Permission(PermissionNames.USER_WRITE, "Create/modify users", "user", "write");
		Permission userDelete = new Permission(PermissionNames.USER_DELETE, "Delete users", "user", "delete");


		if ( !permissionRepository.existsByName(PermissionNames.USER_READ) ) {
			permissionRepository.save(userRead);
		}
		if ( !permissionRepository.existsByName(PermissionNames.USER_WRITE) ) {
			permissionRepository.save(userWrite);
		}
		if ( !permissionRepository.existsByName(PermissionNames.USER_DELETE) ) {
			permissionRepository.save(userDelete);
		}

		Role userRole = roleRepository.findByName("USER").orElse(null);
		if( userRole == null ) {
			userRole = new Role("USER", "Standard user access");
			userRole.setPermissions(Set.of(userRead));
			roleRepository.save(userRole);
		}
		Role adminRole = roleRepository.findByName("ADMIN").orElse(null);
		if( adminRole == null ) {
			adminRole = new Role("ADMIN", "Full system access");
			adminRole.setPermissions(Set.of(userRead,userWrite,userDelete));
			roleRepository.save(adminRole);
		}

		User admin = userRepository.findByUsername("admin").orElse(null);
		if ( admin == null ) {
			admin = new User("admin",passwordEncoder.encode("admin"), "admin@admin.com");
			admin.setRoles(Set.of(adminRole,userRole));
			userRepository.save(admin);
		}
		User user = userRepository.findByUsername("user").orElse(null);
		if ( user == null ) {
			user = new User("user", passwordEncoder.encode("user"),"user@user.com");
			user.setRoles(Set.of(userRole));
			userRepository.save(user);
		}

	}
}
