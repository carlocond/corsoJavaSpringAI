package com.azienda.userService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.azienda.userService.filter.JwtFilter;
//1)
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

	private final JwtFilter jwtFilter;
	
	public WebSecurityConfig(JwtFilter jwtFilter) {
		super();
		this.jwtFilter = jwtFilter;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//inietta nell'application context la sua authenticationManager
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain filterChain(
			HttpSecurity http)
					throws Exception {

		return http
				// No CSRF (stateless, no cookies)
				.cors(cors -> cors.disable())
				.csrf(csrf -> csrf.disable())

				// Endpoint access rules
				.authorizeHttpRequests(auth ->
				auth
				.requestMatchers("/api/auth/login").permitAll()
				.anyRequest().authenticated())

				// JWT filter BEFORE standard auth
				.addFilterBefore(
						jwtFilter,
						UsernamePasswordAuthenticationFilter.class)

				.build();
	}
}
