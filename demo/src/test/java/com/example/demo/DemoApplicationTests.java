package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
// import org.springframework.transaction.annotation.Transactional;
// import lombok.extern.slf4j.Slf4j;
// import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
// import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import com.example.restservice.application.controller.GreetingController;
import com.example.restservice.application.resource.Greeting;
import org.springframework.core.ParameterizedTypeReference;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.web.servlet.MockMvc;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import com.example.restservice.application.controller.GreetingController;

/**
 * 参考
 * https://b1san-blog.com/post/spring/spring-test/
 * https://reasonable-code.com/controller-unit-test/
 * https://spring.pleiades.io/guides/gs/testing-web/
 *
 */
// @RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
// @ContextConfiguration(classes = GreetingController.class)
// @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringBootTest(classes = GreetingController.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@LocalServerPort
	private int port = 8090;

	@Test
	public void contextLoads() {

		String url = "http://localhost:" + this.port + "/greeting";

		// ResponseEntity<List<Counter>> result = testRestTemplate.exchange(url,
		// HttpMethod.GET, HttpEntity.EMPTY,
		// new ParameterizedTypeReference<List<Counter>>() {
		// });
		// this.testRestTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
		// new ParameterizedTypeReference<Greeting>() {
		// });
		ResponseEntity<Greeting> result = this.testRestTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
				new ParameterizedTypeReference<Greeting>() {
				});

		System.out.println(result.getBody().getId());
		// System.out.println(result.getBody().size());

		// try {
		// //
		// mockMvc.perform(get("/com/example/restservice/greeting")).andExpect(status().isOk());
		// mockMvc.perform(get("/greeting")).andExpect(status().isOk());
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

}
