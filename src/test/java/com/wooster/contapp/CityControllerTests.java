package com.wooster.contapp;

import static org.assertj.core.api.Assertions.assertThat;

import com.wooster.contapp.entity.City;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CityControllerTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate template;
	
	@Test
	public void getCityTest() throws Exception {
		assertThat(this.template.getForObject("http://localhost:" + port 
				+ "/api/v1/cities",City[].class)).hasSizeGreaterThanOrEqualTo(2);
	}

}
