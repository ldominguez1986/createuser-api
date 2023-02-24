/**
 * 
 */
package cl.ldominguez.createuser;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import cl.ldominguez.createuser.domain.dto.TelefonoDto;
import cl.ldominguez.createuser.domain.dto.UsuarioDto;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ldominguez
 *
 */
@Slf4j
@SpringBootTest(classes = TestApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestCreateUser {
	
	@LocalServerPort
	private int port;
	
	@Test
	void createUser() throws InterruptedException {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:" + port + "/api/testjava-v1/usuarios/create";
		try {
			UsuarioDto user = new UsuarioDto();
			user.setName("Luis Dominguez");
			user.setEmail("luis.dominguez.navarrete@gmail.com");
			user.setPassword("Ab12345");
			
			List<TelefonoDto> phones = new ArrayList<>();
			TelefonoDto phone = new TelefonoDto();
			phone.setCitycode("9");
			phone.setCountrycode("56");
			phone.setNumber("993458950");
			phones.add(phone);
			
			user.setPhones(phones);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<UsuarioDto> request = new HttpEntity<>(user, headers);
			
			
			ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
			log.info("response: " + response);
			
			Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(HttpStatus.CREATED.value());
		} catch (HttpClientErrorException e) {
			Assertions.assertThat(e.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		}
	}

}
