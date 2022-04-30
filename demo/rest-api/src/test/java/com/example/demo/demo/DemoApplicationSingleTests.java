package com.example.demo.demo;

import org.junit.Test;

import com.example.demo.base.RestApiBaseTest;
import java.util.List;
import org.springframework.http.ResponseEntity;
import com.example.demo.common.constants.AppServerServiceURI;
import com.example.demo.controller.response.GreetingResponse;

public class DemoApplicationSingleTests extends RestApiBaseTest<DemoApplicationSingleTests, String, GreetingResponse> {

	@Override
	public void setProperty() {
		super.logCls = DemoApplicationSingleTests.class;
		super.responseCls = GreetingResponse.class;
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test0001() {

		ResponseEntity<List<GreetingResponse>> wkResult = (ResponseEntity<List<GreetingResponse>>) super.curlGetList(
				AppServerServiceURI.GET_GREETING);

		logger.info("> STATUS: {}", wkResult.getStatusCode());

		for (GreetingResponse one : super.getResponseList) {
			logger.info("> ID: {}", one.getId());
			logger.info("> NAME: {}", one.getName());
		}

	}

}
