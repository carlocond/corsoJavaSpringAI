package com.azienda.esercizioRestClient.client;

import com.azienda.esercizioRestClient.dto.LocalitaDto;
import com.azienda.esercizioRestClient.dto.TemperaturaDto;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;


@Component
public class LocalitaRestClient {

	private final RestClient restClient;

	public LocalitaRestClient(RestClient restClient) {
		super();
		this.restClient = restClient;
	}
	
	public void getById() {
		try {
			LocalitaDto loc = restClient.get()
					.uri("/getById/{id}",1)
					.retrieve()
					.body(LocalitaDto.class);
			System.out.println(loc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getAll() {
		try {
			List<LocalitaDto> locs = restClient.get()
					.uri("/all")
					.retrieve()
					.body(new ParameterizedTypeReference<>() {});
			locs.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void create() {
		try {
			LocalitaDto dto = new LocalitaDto(1, "Napoli", 18d);
			LocalitaDto response = restClient.post()
					.uri("/save")
					.body(dto)
					.retrieve()
					.body(LocalitaDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void put() {
		try {
			LocalitaDto loc = new LocalitaDto();
			loc.setId(1);
			loc.setCitta("Palmi");
			loc.setTemperatura(-20d);
			ResponseEntity<LocalitaDto> response = restClient.put()
					.uri("/updateLoca")
					.body(loc)
					.retrieve()
					.toEntity(LocalitaDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void patch() {
		try {
			LocalitaDto loc = new LocalitaDto();
			loc.setId(1);
			loc.setTemperatura(-50d);
			ResponseEntity<LocalitaDto> response = restClient.patch()
					.uri("/patchLoca")
					.body(loc)
					.retrieve()
					.toEntity(LocalitaDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTempInf() {
		try {
			TemperaturaDto tempDto = new TemperaturaDto(21d);
			ResponseEntity<Void> r =restClient.method(HttpMethod.DELETE)
					.uri("/deleteTempsInf")
					.body(tempDto)
					.retrieve()
					.toBodilessEntity();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
