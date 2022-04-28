package com.example.demo.base;

import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.common.config.PropertyConfig;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.test.context.TestPropertySource;
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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Before;

import org.springframework.http.RequestEntity;
import org.springframework.http.HttpHeaders;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "/application.local.properties")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class RestApiBaseTest<T1, T2, T3> {

	protected Class<T1> logCls;

	protected T2 param;

	protected Logger logger;

	private String base_url;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@LocalServerPort
	private int port = 8090;

	public abstract void setProperty();

	private String endPoint;

	protected List<T3> getResponseList;

	protected T3 getResponse;

	public Class<T3> responseCls;

	@Autowired
	private PropertyConfig propService;

	protected HttpHeaders headers;

	protected List<Map<String, Object>> assertDataList;
	protected Map<String, Object> assertDataMap;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	protected String chkSql;

	@Before
	public void setUp() {

		setProperty();

		this.base_url = this.propService.getBaseurl();

		this.logger = LoggerFactory.getLogger(this.logCls);

		this.assertDataList = new ArrayList<Map<String, Object>>();
		this.assertDataMap = new LinkedHashMap<>();

		this.logger.info("■■■■■ START ■■■■■");

	}

	/**
	 * リクエスト先URI生成
	 * 
	 * @param endPointResource エンドポイント
	 * 
	 */
	private void createEndPoint(String endPointResource) {
		this.endPoint = this.base_url + this.port + endPointResource;
	}

	/**
	 * HTTPリクエスト(GET)実行
	 * 
	 * @param endPointResource リクエスト先URI
	 * @return リクエスト結果(n件)
	 * 
	 */
	protected ResponseEntity<? extends Object> curlGetList(String endPointResource) {

		createEndPoint(endPointResource);

		HttpEntity<T2> entity = new HttpEntity<>(this.param);

		ResponseEntity<List<T3>> result = (ResponseEntity<List<T3>>) this.testRestTemplate.exchange(this.endPoint,
				HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<T3>>() {
				});

		createGetList(result);

		return result;

	}

	/**
	 * HTTPリクエスト(GET)実行
	 * 
	 * @param endPointResource リクエスト先URI
	 * @return リクエスト結果(1件)
	 * 
	 */
	protected ResponseEntity<? extends Object> curlGet(String endPointResource) {

		createEndPoint(endPointResource);

		HttpEntity<T2> entity = new HttpEntity<>(this.param);

		ResponseEntity<T3> result = (ResponseEntity<T3>) this.testRestTemplate.exchange(this.endPoint,
				HttpMethod.GET, entity,
				this.responseCls);

		createGet(result);

		return result;

	}

	/**
	 * HTTPリクエスト(POST)実行
	 * 
	 * @param endPointResource リクエスト先URI
	 * 
	 */
	protected ResponseEntity<?> curlPost(String endPointResource) {

		createEndPoint(endPointResource);

		RequestEntity<?> requestEntity;

		try {
			requestEntity = RequestEntity
					.post(new URI(this.endPoint))
					.headers(this.headers)
					.body(this.param);

			return this.testRestTemplate.exchange(requestEntity, Object.class);

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

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

	/**
	 * データ取得
	 * 
	 * @param sql 実行SQL
	 * @return 取得結果
	 * 
	 */
	protected List<Map<String, Object>> getData(String sql) {
		return jdbcTemplate.queryForList(sql);
	}

	/**
	 * 期待値と実測値が一致するかの検証
	 * 
	 */
	protected void chkAssertData() {

		List<Map<String, Object>> getDataList = getData(this.chkSql);

		assertThat(getDataList.size(), is(assertDataList.size()));

		for (Map<String, Object> oneAssertMap : assertDataList) {

			for (String assertKey : oneAssertMap.keySet()) {

				Object val = oneAssertMap.get(assertKey);

				for (Map<String, Object> oneMap : getDataList) {

					if (!oneMap.containsKey(assertKey)) {
						continue;
					}

					logger.info("Column Name:[{}]、Value:[{}]", assertKey, oneMap.get(assertKey));
					assertThat(oneMap.get(assertKey), is(val));

				}
			}

		}

	}

}
