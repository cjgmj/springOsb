package com.cjgmj.springOsb.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cjgmj.springOsb.dao.EmployeeDao;
import com.cjgmj.springOsb.entity.Employee;

@Repository("employeeDao")
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	private static final Logger LOG = Logger.getLogger(EmployeeDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getListEmployee() {
		return (List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
	}

	@Override
	public boolean addEmployee(Employee employee) {
		boolean flag = false;
		sessionFactory.getCurrentSession().save(employee);
		flag = true;
		return flag;
	}

}
