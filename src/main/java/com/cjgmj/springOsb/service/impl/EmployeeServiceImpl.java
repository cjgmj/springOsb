package com.cjgmj.springOsb.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjgmj.springOsb.dao.EmployeeDao;
import com.cjgmj.springOsb.entity.Employee;
import com.cjgmj.springOsb.service.EmployeeService;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOG = Logger.getLogger(EmployeeServiceImpl.class);

	@Autowired
	@Qualifier("employeeDao")
	private EmployeeDao employeeDaoImpl;

	@Override
	public List<Employee> getListEmployee() {
		return employeeDaoImpl.getListEmployee();
	}

	@Override
	public boolean addEmployee(Employee employee) {
		return employeeDaoImpl.addEmployee(employee);
	}

}
