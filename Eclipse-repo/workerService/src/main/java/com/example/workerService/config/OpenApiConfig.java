package com.example.workerService.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {


	@Bean
	public OpenAPI productServiceOpenAPI() {
		Server localServer = new Server();
		localServer.setUrl("http://localhost:8080");
		localServer.setDescription("Local development server");

		Server productionServer = new Server();
		productionServer.setUrl("https://api.demoproject.com");
		productionServer.setDescription("Production server");

		Contact contact = new Contact();
		contact.setName("Rob");
		contact.setEmail("rob@example.com");
		contact.setUrl("https://github.com/rob");

		License license = new License()
		.name("MIT License")
		.url("https://opensource.org/licenses/MIT");

		Info info = new Info()
				.title("Demo Project Service API")
				.version("1.0.0")
				.description("Demo Project Service - Manages enterprises and workers")
				.contact(contact)
				.license(license);

		return new OpenAPI()
				.info(info)
				.servers(List.of(localServer, productionServer));
	}
}