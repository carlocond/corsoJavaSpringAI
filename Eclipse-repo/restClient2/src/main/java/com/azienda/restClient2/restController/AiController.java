package com.azienda.restClient2.restController;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azienda.restClient2.dto.LocalitaAiDto;
import com.azienda.restClient2.service.LocalitaService;
import com.azienda.restClient2.tools.LocalitaTool;

@RestController
@RequestMapping("/api/ai")
public class AiController {

private final LocalitaService service;
	
	private final ChatClient chatClient;
	private final ChatMemory chatMemory;
	
	public AiController(ChatClient.Builder builder, ChatMemory chatMemory, LocalitaService service, LocalitaTool tool) {
		this.chatMemory = chatMemory;
		chatClient = builder.defaultSystem("""
				Tu sei un esperto meteorologo e conosci le attuali temperature di tutte le località nel mondo.
				Devi rispondere in italiano e conciso. Se la risposta non ce l'hai inventala in modo coerente con il clima della città in questione.
				""")
				.defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
				.defaultTools(tool)
				.build();
		this.service = service;
	}
	
	
	@GetMapping("/chat")
	public ResponseEntity<Void> chat(@RequestParam String msg, @RequestParam(defaultValue = "123") String sessionId){
		
		String list=chatClient.prompt().user(msg).call().content();
		List<LocalitaAiDto> listJson = chatClient.prompt()
												.user("Trasformami in json i seguenti dati: "+list)
												.advisors(a-> a.param(ChatMemory.CONVERSATION_ID,sessionId))
												.call()
												.entity(new ParameterizedTypeReference<>() {
		});
		
		return ResponseEntity.ok().build();
	}
	
	@PatchMapping("/aggiornaLoc")
	public ResponseEntity<String> aggiornaLoc(@RequestParam Float nuovaTemp, @RequestParam(defaultValue = "123") String sessionId){
		String response = chatClient.prompt()
									.user("Ti ricordi le temperature delle località che mi hai dato un momento fa? Adesso settale tutte alla temperatura di " + nuovaTemp + " gradi.")
									.advisors(a->a.param(ChatMemory.CONVERSATION_ID, nuovaTemp))
									.call()
									.content();
		
		return ResponseEntity.ok(response);
	}
	
}
