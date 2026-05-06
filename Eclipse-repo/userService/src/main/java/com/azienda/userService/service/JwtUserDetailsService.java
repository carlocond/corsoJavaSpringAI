package com.azienda.userService.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.azienda.userService.model.Permission;
import com.azienda.userService.model.Role;
import com.azienda.userService.model.User;
import com.azienda.userService.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService{

	private final UserRepository userRepository;
	
	public JwtUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.selectByEmail(username).orElseGet(() -> userRepository.selectByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("Username non trovata"))
				);
		
		UserDetails userDetails = map(user);
		return userDetails;
	}

	//trasformiamo i role e permission in simplegrantedauthority
	private Collection<GrantedAuthority> buildAuthority(User user){
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		user.getRoles()
			.stream()
			.map(Role::getName)
			.forEach(roleName -> authorities.add(new SimpleGrantedAuthority("ROLE_" + roleName)));
		
		user.getRoles()
			.stream()
			.flatMap(r -> r.getPermissions().stream())
			.map(Permission::getName)
			.distinct()
			.forEach(permissionName -> authorities.add(new SimpleGrantedAuthority(permissionName)));
			
		
		return authorities;
	}
	
	
	private UserDetails map(User user) {
		return org.springframework.security.core.userdetails.User
				.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.disabled(!user.getEnabled())
				.accountLocked(user.getAccountLocked())
				.accountExpired(user.getAccountExpired())
				.credentialsExpired(user.getCredentialsExpired())
				.authorities(buildAuthority(user))
				.build();
				
	}
	
	
	
	
	
}
