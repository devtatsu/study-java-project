package com.example.demo.demo;

import org.junit.Test;
import com.example.demo.application.controller.request.GreetingResponse;
import com.example.demo.base.RestApiBaseTest;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import com.example.demo.application.common.constants.AppServerServiceURI;

public class DemoApplicationTests3 extends RestApiBaseTest<DemoApplicationTests3, String, GreetingResponse> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setProperty() {
		super.logCls = DemoApplicationTests3.class;
		super.responseCls = GreetingResponse.class;
	}

	@Test
	@SuppressWarnings("unchecked")
	@Sql(scripts = "/deptquery/setUpData.sql")
	public void test0001() {

		List<Map<String, Object>> getData = jdbcTemplate.queryForList("SELECT * FROM DEPT");

		ResponseEntity<List<GreetingResponse>> wkResult = (ResponseEntity<List<GreetingResponse>>) super.curlGetList(
				AppServerServiceURI.GET_GREETING);

		logger.info("> STATUS: {}", wkResult.getStatusCode());

		for (GreetingResponse one : super.getResponseList) {
			logger.info("> ID: {}", one.getId());
			logger.info("> NAME: {}", one.getName());
		}

	}

}
