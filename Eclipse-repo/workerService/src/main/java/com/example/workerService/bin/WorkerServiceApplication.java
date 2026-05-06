package com.example.workerService.bin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.example.workerService.service",
											"com.example.workerService.controller",
											"com.example.workerService.config",
											"com.example.workerService.dto",
											"com.example.workerService.exception"})
@EnableJpaRepositories(basePackages = {"com.example.workerService.repository"})
@EntityScan(basePackages = {"com.example.workerService.model"})
public class WorkerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkerServiceApplication.class, args);
	}

}
