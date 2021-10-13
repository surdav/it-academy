package com.itacademy.CrudEmpleats.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@NotNull
	private int id;
	
	@NotBlank
	@Column(name="name")
	private String name;
	
	@NotBlank
	@Column(name="job")
	private String job;
	
	@Column(name="salary")
	private double salary;

	public Employee() {}

	// salario y cargo en función de la clase Jobs Enum.
	public Employee(int id, String name, String job) {
		this.id = id;
		this.name = name;
		this.job = Jobs.valueOf(job).getName();
		this.salary = Jobs.valueOf(job).getSalary();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = Jobs.valueOf(job).getName();
		this.salary = Jobs.valueOf(job).getSalary();
	}

	public double getSalary() {
		return salary;
	}	
	
}
