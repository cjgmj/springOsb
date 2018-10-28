package com.cjgmj.springOsb.dao;

import java.util.List;

import com.cjgmj.springOsb.entity.Employee;

public interface EmployeeDao {

	public List<Employee> getListEmployee();

	public boolean addEmployee(Employee employee);
	
	public Employee getByIdEmployee(Long id);
	
	public void deleteEmployee(Long id);

}
