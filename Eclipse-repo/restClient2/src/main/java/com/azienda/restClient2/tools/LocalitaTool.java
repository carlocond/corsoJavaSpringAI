package com.azienda.restClient2.tools;

import java.util.List;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import com.azienda.restClient2.dto.LocalitaAiDto;
import com.azienda.restClient2.service.LocalitaService;

@Component
public class LocalitaTool {

private final LocalitaService service;
	
	public LocalitaTool(LocalitaService service) {
		this.service=service;
	}
	
	@Tool(description  = "Inserisce le località nel database")
	public List<LocalitaAiDto> inserisciInDatabase(@ToolParam(description = "lista di località da inserire nel db") List<LocalitaAiDto> listaLocalita) {
		
		return service.creaDaLista(listaLocalita);
		
	}
	
	@Tool(description ="Modifica la temperatura delle località in base ai dati in input se sono presenti nel database")
	public List<LocalitaAiDto> modificaLocalita(List<LocalitaAiDto> dto,Float nuovaTemp){
		dto.forEach(l->service.updateByIdNewTemperatura(service.readByNome(l.localita()).getId(), nuovaTemp));
		return service
				.readAll()
				.stream()
				.filter(l->
					l.getTemperatura().equals(nuovaTemp))
						.toList()
						.stream()
						.map(l->new LocalitaAiDto(l.getId(),l.getNome(), nuovaTemp))
						.toList();
	}
	
}
