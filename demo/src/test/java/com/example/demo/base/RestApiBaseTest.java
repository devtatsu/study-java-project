package com.example.demo.base;

import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.After;
import org.junit.Before;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class RestApiBaseTest<T1, T2, T3> {

	protected Class<T1> logCls;

	protected T2 param;

	protected Logger logger;

	protected static String BASE_URL = "http://localhost:";

	@Autowired
	protected TestRestTemplate testRestTemplate;

	@LocalServerPort
	protected int port = 8090;

	public abstract void setProperty();

	private String endPoint;

	protected List<T3> getResponseList;

	protected T3 getResponse;

	public Class<T3> responseCls;

	@Before
	public void setUp() {

		setProperty();

		this.logger = LoggerFactory.getLogger(this.logCls);

		this.logger.info("■■■■■ START ■■■■■");

	}

	protected ResponseEntity<? extends Object> curlGetList(String endPointResource) {

		this.endPoint = BASE_URL + this.port + endPointResource;

		HttpEntity<T2> entity = new HttpEntity<>(this.param);

		ResponseEntity<List<T3>> result = (ResponseEntity<List<T3>>) this.testRestTemplate.exchange(this.endPoint,
				HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<T3>>() {
				});

		createGetList(result);

		return result;

	}

	protected ResponseEntity<? extends Object> curlGet(String endPointResource) {

		this.endPoint = BASE_URL + this.port + endPointResource;

		HttpEntity<T2> entity = new HttpEntity<>(this.param);

		ResponseEntity<T3> result = (ResponseEntity<T3>) this.testRestTemplate.exchange(this.endPoint,
				HttpMethod.GET, entity,
				this.responseCls);

		createGet(result);

		return result;

	}

	private void createGetList(ResponseEntity<List<T3>> result) {

		ObjectMapper mapper = new ObjectMapper();

		this.getResponseList = new ArrayList<>();

		for (int i = 0; i < result.getBody().size(); i++) {
			try {
				this.getResponseList
						.add((T3) mapper.readValue(objToJsonStr(result.getBody().get(i)), this.responseCls));
			} catch (JsonMappingException e) {
				this.logger.error("json mapper error(JsonMappingException): {}", e.getMessage());
			} catch (JsonProcessingException e) {
				this.logger.error("json mapper error(JsonProcessingException): {}", e.getMessage());
			}

		}

	}

	private void createGet(ResponseEntity<T3> result) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			this.getResponse = mapper.readValue(objToJsonStr(result.getBody()), this.responseCls);
		} catch (JsonMappingException e) {
			this.logger.error("json mapper error(JsonMappingException): {}", e.getMessage());
		} catch (JsonProcessingException e) {
			this.logger.error("json mapper error(JsonProcessingException): {}", e.getMessage());
		}

	}

	/**
	 * JSON 文字列変換<br>
	 * <br>
	 *
	 * @param json JSONオブジェクト
	 * @return 文字列型JSON
	 * @throws JsonProcessingException JSON変換に失敗した場合
	 */
	private String objToJsonStr(Object json) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(json);
	}

	@After
	public void endtMsg() {
		this.logger.info("■■■■■ END ■■■■■");
	}

}
