package com.example.esempioRestClient.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.example.esempioRestClient.dto.PersonaDto;

@Component
public class PersonaRestClient {

	private final RestClient restClient;
	
	public PersonaRestClient(RestClient restClient) {
		this.restClient = restClient;
	}
	
	public void testGetById() {
		
		try {
			
			PersonaDto pDto = restClient.get()
										.uri("/getById/{id}", 1)
										.retrieve()
										.body(PersonaDto.class);
			System.out.println(pDto);
			
			try {
				pDto = restClient.get()
						.uri("/getById/{id}", 2)
						.retrieve()
						.body(PersonaDto.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				pDto = restClient.get()
						.uri("/getById/{id}", -1)
						.retrieve()
						.body(PersonaDto.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
