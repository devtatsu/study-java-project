package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.example.demo.application.controller.GreetingController;
import com.example.demo.application.controller.request.GreetingResponse;
import com.example.demo.application.resource.Greeting;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.core.ParameterizedTypeReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests2 {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplicationTests2.class);

	private static String baseUrl = "http://localhost:";

	private String bufMethodName;

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

		String url = baseUrl + this.port + "/greeting";

		outStartEndMsg();

		ResponseEntity<Greeting> result = this.testRestTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
				new ParameterizedTypeReference<Greeting>() {
				});

		logger.info("> ID: {}", result.getBody().getId());

		outStartEndMsg();

	}

	@Test
	public void test0002() {

		String url = baseUrl + this.port + "/getgreeting";

		outStartEndMsg();

		ResponseEntity<List<GreetingResponse>> result = this.testRestTemplate.exchange(url, HttpMethod.GET,
				HttpEntity.EMPTY,
				new ParameterizedTypeReference<List<GreetingResponse>>() {
				});

		logger.info("> 件数: {}", result.getBody().size());

		outStartEndMsg();

	}

	/**
	 * 開始終了のメッセージログ
	 * 
	 */
	private void outStartEndMsg() {

		String methodName = getMethodName();

		if (bufMethodName == null) {
			bufMethodName = methodName;
			logger.info("■■■■■ {} START ■■■■■", methodName);
			return;
		}

		if (bufMethodName == methodName) {
			logger.info("■■■■■ {} END ■■■■■", methodName);
			return;
		}

		logger.info("■■■■■ {} START ■■■■■", methodName);

	}

	/**
	 * メソッド名取得
	 * 
	 * @return メソッド名
	 * 
	 */
	private String getMethodName() {
		return Thread.currentThread().getStackTrace()[3].getMethodName();
	}

}
