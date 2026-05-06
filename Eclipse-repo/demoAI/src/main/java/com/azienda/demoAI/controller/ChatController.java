package com.azienda.demoAI.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
	
	private final ChatClient chatClient;
	
	public ChatController(ChatClient.Builder builder) {
		chatClient = builder.defaultSystem("Sei un assistente esperto di tecnologia. Rispondi in italiano, in modo chiaro e conciso.")
				.build();
	}
	
	@GetMapping
	public String chat(@RequestParam String message) {
		
		try {
			
			return chatClient
				.prompt()
				.user(message)
				.call()
				.content();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return "";
		}
		
		
		
	}

}
