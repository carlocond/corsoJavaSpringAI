package com.azienda.userService.utils;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

	public static boolean hasPermission(String permission) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) auth.getAuthorities();
		
		return authorities
				.stream()
				.anyMatch(a -> a.getAuthority().equals(permission));
	}
	
	
}
