package com.example.demo.application.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.application.resource.Greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.application.common.constants.AppServerServiceURI;
import com.example.demo.application.controller.request.GreetingResponse;
import com.example.demo.application.domain.services.GreetingService;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

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

}