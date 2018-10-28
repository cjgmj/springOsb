package com.cjgmj.springOsb.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
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

	@Override
	public Employee getByIdEmployee(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Employee as e WHERE e.id=:id");
		query.setParameter("id", id);
		List<Employee> queryList = (List<Employee>) query.list();
		if (queryList.size() > 0)
			return queryList.get(0);

		return null;
	}

	@Override
	public void deleteEmployee(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee as e WHERE e.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
