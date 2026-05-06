package com.azienda.demoAI.bin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.azienda.demoAI.controller"})
public class DemoAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAiApplication.class, args);
	}

}
