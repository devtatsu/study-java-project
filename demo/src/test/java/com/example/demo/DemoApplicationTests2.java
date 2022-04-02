package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.example.demo.application.controller.GreetingController;
import com.example.demo.application.resource.Greeting;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.core.ParameterizedTypeReference;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests2 {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@LocalServerPort
	private int port = 8090;

	@Autowired
	private GreetingController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	public void test0001() {

		String url = "http://localhost:" + this.port + "/greeting";

		ResponseEntity<Greeting> result = this.testRestTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
				new ParameterizedTypeReference<Greeting>() {
				});

		System.out.println(result.getBody().getId());

	}

}
