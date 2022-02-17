package com.app.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class AppService {
	
	@Autowired
	WebClient.Builder webClientBuilder;
	
	public String getCallUsingWebClient() {
		return webClientBuilder.build()
						.get()
						.uri("http://localhost:8080/reactive-spring-webapp/one")
						.retrieve()
						.bodyToMono(String.class)
						.block();
	}
	
	public String postCallUsingWebClient() {
		return webClientBuilder.build()
						.post()
						.uri("http://localhost:8080/reactive-spring-webapp/two")
						.body(Mono.just("Inside post mappping"), String.class)
						.retrieve()
						.bodyToMono(String.class)
						.block();
	}
}
