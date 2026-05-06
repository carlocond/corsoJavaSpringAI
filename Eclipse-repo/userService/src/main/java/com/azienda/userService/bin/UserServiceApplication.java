package com.azienda.userService.bin;

import com.azienda.userService.service.AuthService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.azienda.userService.controller",
											"com.azienda.userService.service",
											"com.azienda.userService.dto",
											"com.azienda.userService.config",
											"com.azienda.userService.exception",
											"com.azienda.userService.utils",
											"com.azienda.userService.filter"})

@EnableJpaRepositories(basePackages = "com.azienda.userService.repository")
@EntityScan(basePackages = "com.azienda.userService.model")
public class UserServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(UserServiceApplication.class, args);
		AuthService authService = context.getBean("authService", AuthService.class);
		authService.init();
	}

}
