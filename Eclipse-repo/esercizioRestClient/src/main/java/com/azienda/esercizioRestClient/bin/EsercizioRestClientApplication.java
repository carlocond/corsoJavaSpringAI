package com.azienda.esercizioRestClient.bin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

import com.azienda.esercizioRestClient.client.LocalitaRestClient;

@SpringBootApplication(scanBasePackages = {"com.azienda.esercizioRestClient.client"})
public class EsercizioRestClientApplication {

	public static void main(String[] args) {
		
		try(ConfigurableApplicationContext context =  SpringApplication.run(EsercizioRestClientApplication.class, args)){
			
			LocalitaRestClient client =  context.getBean("localitaRestClient", LocalitaRestClient.class);
			client.create();
			client.getById();
			client.getAll();
			client.put();
			client.patch();
			client.deleteTempInf();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Bean
	public RestClient restClient(@Value("${serverUrl}") String url ) {
		
		return RestClient.builder()
				.baseUrl(url)
				.build();
	}

}
