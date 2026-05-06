package com.example.esempioRestClient.bin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

import com.example.esempioRestClient.client.PersonaRestClient;

@SpringBootApplication(scanBasePackages = {"com.example.esempioRestClient.client"})
public class EsempioRestClientApplication {

	public static void main(String[] args) {
		
		try (ConfigurableApplicationContext context = SpringApplication.run(EsempioRestClientApplication.class, args)){
			
			PersonaRestClient client = context.getBean("personaRestClient", PersonaRestClient.class);
			client.testGetById();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Bean
	public RestClient restClient(@Value ("${serverUrl}") String url){
		
		return RestClient.builder()
						.baseUrl(url)
						.build();
		
	}

}
