package com.azienda.userService.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.azienda.userService.utils.JwtUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{

	private final JwtUtils jwtUtils;

	
	public JwtFilter(JwtUtils jwtUtils) {
		super();
		this.jwtUtils = jwtUtils;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String header = request.getHeader("Authorization");
		
		if(header != null && header.startsWith("Bearer")) {
			String token = header.substring(7);
			String username = jwtUtils.extractUsername(token);
			List<String> roles = jwtUtils.extractRoles(token);
			List<String> permissions = jwtUtils.extractPermission(token);
			Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
			
			roles.stream().distinct().forEach(r -> authorities.add(new SimpleGrantedAuthority("ROLE_" + r)));
			permissions.stream().distinct().forEach(p -> authorities.add(new SimpleGrantedAuthority(p)));
			
			UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(username, null, authorities);
			SecurityContextHolder.getContext().setAuthentication(upat);
		}
		
		filterChain.doFilter(request, response);
		
	}

}
