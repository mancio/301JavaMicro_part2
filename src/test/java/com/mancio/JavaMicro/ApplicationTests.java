package com.mancio.JavaMicro;

import com.mancio.JavaMicro.entities.Employees;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getUrl() {
		return "http://localhost:" + port;
	}

	private String getWrongPath() {
		// employees is misspelled;
		return getUrl() + "/empploys/0";
	}

	@Test
	public void TestGetAllEmpl() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getUrl() + "/employees",
				HttpMethod.GET, entity, String.class);
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetEmpById() {
		Employees employee = restTemplate.getForObject(getUrl() + "/employees/0", Employees.class);
		System.out.println(employee.getEmployee_name());
		assertNotNull(employee);
	}

	@Test
	public void testAddEmpl() {
		Employees employee = new Employees();
		employee.setEmployee_name("Rob");
		employee.setEmployee_last_name("Maverick");
		employee.setEmployee_phone("+47764784885");
		employee.getEmployee_address(".ul dolny 5 30-768 Cracow Poland");
		employee.setJob_position("java dev");
		employee.setCurrency("EUR");
		employee.setSalary(3000);
		ResponseEntity<Employees> postResponse = restTemplate.postForEntity(getUrl() + "/employees", employee, Employees.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testDeleteEmpl() {
		int id = 1;
		Employees employee = restTemplate.getForObject(getUrl() + "/employees/" + id, Employees.class);
		assertNotNull(employee);
		restTemplate.delete(getUrl() + "/employees/" + id);
		try {
			restTemplate.getForObject(getUrl() + "/employees/" + id, Employees.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

	@Test
	public void testWrongUrl() {
		try {
			restTemplate.getForObject(getWrongPath(), Employees.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}


