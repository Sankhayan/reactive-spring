package com.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.web.service.AppService;

@RestController
@RequestMapping("/reactive-spring-webapp")
public class WebController {

	@Autowired
	private AppService service;
	
	@GetMapping("/one")
	public String one() {
		return "Inside get mappping";
	}
	
	@PostMapping("/two")
	public String two(@RequestBody String s) {
		return s;	
	}
	
	@GetMapping("/get")
	public String get() {
		return service.getCallUsingWebClient() + " from get call";
	}
	
	@PostMapping("/post")
	public String post(@RequestBody String s) {
		return service.postCallUsingWebClient() + " from post call";
	}
}
