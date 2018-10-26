package com.cjgmj.springOsb.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="task", schema="devsoa")
public class Task implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 13789171630191052L;
	
	@Id
	@Column(name="task_id")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="sequence")
	@SequenceGenerator(name="sequence", sequenceName="task_seq")
	private Long id;

	@Column(name="task_name")
	private String name;
	
	@Column(name="emp_id")
	private Employee employee;
	
	@Column(name="task_dateini")
	private LocalDateTime data_ini;
	
	@Column(name="task_date_end")
	private LocalDateTime data_end;
	
	@Column(name="task_status")
	private Long status;
	
	public Task() {
	}

	public Task(Long id, String name, Employee employee, LocalDateTime data_ini, LocalDateTime data_end, Long status) {
		super();
		this.id = id;
		this.name = name;
		this.employee = employee;
		this.data_ini = data_ini;
		this.data_end = data_end;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LocalDateTime getData_ini() {
		return data_ini;
	}

	public void setData_ini(LocalDateTime data_ini) {
		this.data_ini = data_ini;
	}

	public LocalDateTime getData_end() {
		return data_end;
	}

	public void setData_end(LocalDateTime data_end) {
		this.data_end = data_end;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}
	
}
