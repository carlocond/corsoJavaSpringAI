package com.azienda.gateway.filter;

import java.util.List;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.azienda.gateway.utils.JwtUtils;

import reactor.core.publisher.Mono;

@Component
public class JwtFilter implements GlobalFilter, Ordered{

	private final JwtUtils jwtUtils;

	public JwtFilter(JwtUtils jwtUtils) {
		super();
		this.jwtUtils = jwtUtils;
	}

	@Override
	public int getOrder() {
		
		return 0;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		ServerHttpRequest request = exchange.getRequest();
		String authHeader = request.getHeaders().getFirst("Authorization");
		
		if(authHeader != null && authHeader.startsWith("Bearer")){
			String token = authHeader.substring("Bearer".length()+1);
			String username = jwtUtils.extractUsername(token);
			Long userId = jwtUtils.extractUserId(token);
			List<String> roles = jwtUtils.extractRoles(token);
			List<String> permissions = jwtUtils.extractPermission(token);
			
			//clone request uguale alla originale che serve per formare la risposta
			ServerHttpRequest cloned = request.mutate()
					.header("X-Username", username)
					.header("X-User-Id", ""+userId)
					.header("X-User-Roles", String.join(",", roles))
					.header("X-User-Permissions", String.join(",", permissions))
					.build();
			
			return chain.filter(exchange.mutate().request(cloned).build());
		}
					
		return chain.filter(exchange);
	}
	
	
}
