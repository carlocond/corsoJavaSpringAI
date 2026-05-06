package com.azienda.restClient2.bin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.azienda.restClient2.exception",
											"com.azienda.restClient2.restController",
											"com.azienda.restClient2.service",
											"com.azienda.restClient2.tools"})
@EntityScan(basePackages = "com.azienda.restClient2.model")
@EnableJpaRepositories(basePackages = "com.azienda.restClient2.repository")
public class RestClient2Application {

	public static void main(String[] args) {
		
		try(ConfigurableApplicationContext context = SpringApplication.run(RestClient2Application.class, args)) {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
