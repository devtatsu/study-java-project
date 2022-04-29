package com.example.demo.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.example.demo.application.controller.GreetingController;
import com.example.demo.application.controller.response.GreetingResponse;
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
import com.example.demo.application.common.constants.AppServerServiceURI;
import org.springframework.test.context.TestPropertySource;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "/application.local.properties")
public class SampleDemoApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(SampleDemoApplicationTests.class);

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

		String url = baseUrl + this.port + AppServerServiceURI.GREETING;

		outStartEndMsg();

		ResponseEntity<Greeting> result = this.testRestTemplate.exchange(url,
				HttpMethod.GET, HttpEntity.EMPTY,
				new ParameterizedTypeReference<Greeting>() {
				});

		logger.info("> ID: {}", result.getBody().getId());

		outStartEndMsg();

	}

	@Test
	public void test0002() {

		String url = baseUrl + this.port + AppServerServiceURI.GET_GREETING;

		outStartEndMsg();

		ResponseEntity<List<GreetingResponse>> result = this.testRestTemplate.exchange(url, HttpMethod.GET,
				HttpEntity.EMPTY,
				new ParameterizedTypeReference<List<GreetingResponse>>() {
				});

		logger.info("> 件数: {}", result.getBody().size());

		outStartEndMsg();

	}

	@Test
	public void test0003() {

		String url = baseUrl + this.port + AppServerServiceURI.GET_GREETING_TEST;

		outStartEndMsg();

		ResponseEntity<List<GreetingResponse>> result = this.testRestTemplate.exchange(url, HttpMethod.GET,
				HttpEntity.EMPTY,
				new ParameterizedTypeReference<List<GreetingResponse>>() {
				});

		logger.info("> 件数: {}", result.getBody().size());

		for (GreetingResponse oneRecord : result.getBody()) {
			logger.info("> 件数: {}", oneRecord.getId());
		}

		for (int i = 0; i < result.getBody().size(); i++) {
			logger.info("> {} 件目", i + 1);
			logger.info("> ID: {}", result.getBody().get(i).getId());
			logger.info("> NAME: {}", result.getBody().get(i).getName());
		}

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
