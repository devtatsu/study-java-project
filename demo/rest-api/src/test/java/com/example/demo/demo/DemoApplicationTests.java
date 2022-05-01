package com.example.demo.demo;

import org.junit.Test;
import com.example.demo.resource.Greeting;
import com.example.demo.base.RestApiBaseTest;
import org.springframework.http.ResponseEntity;
import com.example.demo.common.constants.AppServerServiceURI;

public class DemoApplicationTests extends RestApiBaseTest<DemoApplicationTests, String, Greeting> {

	@Override
	public void setProperty() {
		super.logCls = DemoApplicationTests.class;
		super.responseCls = Greeting.class;
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test0001() {

		super.responseCls = Greeting.class;

		ResponseEntity<Greeting> wkResult = (ResponseEntity<Greeting>) super.curlGet(
				AppServerServiceURI.GREETING);

		logger.info("> STATUS: {}", wkResult.getStatusCode());
		logger.info("> ID: {}", getResponse.getId());
		logger.info("> NAME: {}", getResponse.getContent());

	}

	@Test
	@SuppressWarnings("unchecked")
	public void test0002() {

		super.responseCls = Greeting.class;

		for (int i = 0; i < 3; i++) {
			ResponseEntity<Greeting> wkResult = (ResponseEntity<Greeting>) super.curlGet(
					AppServerServiceURI.GREETING);

			logger.info("> STATUS: {}", wkResult.getStatusCode());
			logger.info("> ID: {}", getResponse.getId());
			logger.info("> NAME: {}", getResponse.getContent());
		}

	}

}
