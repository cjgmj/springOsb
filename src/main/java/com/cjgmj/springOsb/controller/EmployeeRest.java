package com.cjgmj.springOsb.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cjgmj.springOsb.entity.Employee;
import com.cjgmj.springOsb.service.EmployeeService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/employee")
public class EmployeeRest {

	private static final Logger LOG = Logger.getLogger(EmployeeRest.class);

	@Autowired
	@Qualifier("employeeService")
	private EmployeeService employeeServiceImpl;

	@RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
	public String getEmployeeJson(@PathVariable String name) {
		Gson gson = new Gson();
		String jsonEmployee = "";
		List<Employee> listEmployee = new ArrayList<>();

		try {
			listEmployee = employeeServiceImpl.getListEmployee();
			LOG.info("La cantidad de empleados es: " + listEmployee.size());
			jsonEmployee = gson.toJson(listEmployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonEmployee;
	}

	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST, produces = "aplicattion/json")
	public String saveEmployee(@RequestBody Employee employee) {
		String jsonEmployee = "";
		boolean getResponse = false;

		try {
			getResponse = employeeServiceImpl.addEmployee(employee);
			jsonEmployee = getResponse == true ? "1" : "0";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonEmployee;
	}

}
