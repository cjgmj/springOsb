package com.cjgmj.springOsb.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.cjgmj.springOsb.entity.Employee;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class EmployeeTest {

	private static final Logger LOG = Logger.getLogger(EmployeeTest.class);

	private static final String ENDPOINT = "http://localhost:7101/EmployeeRest/Proxies/PipelineRestEmployee-proxy";

	@Test
	public void testWSRest() {
		try {

			RestTemplate restTemplate = new RestTemplate();
			String resultGetEmployee = restTemplate.getForObject(ENDPOINT + "/employee/ws", String.class);
			Gson gson = new Gson();

			Employee[] data = gson.fromJson(resultGetEmployee, Employee[].class);

			for (Employee dat : data) {
				System.out.println("Name employee: " + dat.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddEmployee() {
		try {

			RestTemplate restTemplate = new RestTemplate();

			Employee employee = new Employee();

			employee.setName("Pepe Reina");
			employee.setAlias("preina");
			employee.setPassword("12345");
			employee.setDni("11111111");
			employee.setEmail("preina@yopmail.com");

			Gson gson = new Gson();
			String dataRequest = gson.toJson(employee);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>(dataRequest.toString(), headers);

			ResponseEntity<String> employeeResponse = restTemplate.exchange(ENDPOINT + "/employee/createEmployee",
					HttpMethod.POST, entity, String.class);

			if (employeeResponse.getStatusCode() == HttpStatus.OK) {
				String resultAddEmployee = employeeResponse.getBody();
				LOG.info("Result: " + resultAddEmployee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
