package com.cjgmj.springOsb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "employee", schema = "devsoa")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4186206915682118864L;

	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "emp_seq")
	private Long id;

	@Column(name = "emp_name")
	private String name;

	@Column(name = "emp_alias")
	private String alias;

	@Column(name = "emp_password")
	private String password;

	@Column(name = "emp_dni")
	private String dni;

	@Column(name = "emp_email")
	private String email;

	public Employee() {
	}

	public Employee(Long id, String name, String alias, String password, String dni, String email) {
		super();
		this.id = id;
		this.name = name;
		this.alias = alias;
		this.password = password;
		this.dni = dni;
		this.email = email;
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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
