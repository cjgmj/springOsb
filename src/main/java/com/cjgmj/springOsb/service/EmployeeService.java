package com.cjgmj.springOsb.service;

import java.util.List;

import com.cjgmj.springOsb.entity.Employee;

public interface EmployeeService {

	public List<Employee> getListEmployee();

	public boolean addEmployee(Employee employee);

}
