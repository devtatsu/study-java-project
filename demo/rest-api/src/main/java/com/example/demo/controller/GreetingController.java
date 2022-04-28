package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.resource.Greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.common.constants.AppServerServiceURI;
import com.example.demo.controller.response.GreetingResponse;
import com.example.demo.domain.services.GreetingService;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@RestController
@RequiredArgsConstructor
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	private final GreetingService service;

	@GetMapping(AppServerServiceURI.GREETING)
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping(AppServerServiceURI.GET_GREETING)
	public ResponseEntity<List<GreetingResponse>> getGreeting() {

		List<GreetingResponse> retEntity = this.service.getAccountInfo();

		return new ResponseEntity<>(retEntity, HttpStatus.OK);

	}

	@GetMapping(value = AppServerServiceURI.GET_GREETING_TEST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<GreetingResponse>> getGreetingTest() {

		List<GreetingResponse> retEntity = this.service.getFind();

		return new ResponseEntity<>(retEntity, HttpStatus.OK);

	}

}
