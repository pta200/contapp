package com.wooster.contapp;

import static org.assertj.core.api.Assertions.assertThat;

import com.wooster.contapp.entity.City;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;


@AutoConfigureTestRestTemplate
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CityControllerTests {
	
	@LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate client;
    
	@Test
	public void getCityTest() throws Exception {
		assertThat(this.client.getForObject("http://localhost:" + port 
				+ "/api/v1/cities",City[].class)).hasSizeGreaterThanOrEqualTo(2);
    }

	@Test
	public void addCityTest() throws Exception {
		City city = new City("Los Angeles", "California", "" , "US");
		City response = this.client.postForObject(
			"http://localhost:" + port + "/api/v1/cities",
			city,
			City.class
			);

		assertThat(response.getCountry().equals("US"));
	}

}
