package com.itacademy.CrudEmpleats.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.CrudEmpleats.domain.Employee;
import com.itacademy.CrudEmpleats.persistence.IEmployeeRepository;

@Service
public class EmployeeServices {

	@Autowired
	private IEmployeeRepository repositori;

	public List<Employee> getAllEmployees() {
		return repositori.findAll();
	}
	
	public Employee getEmployeeById(int id){
		return repositori.findById(id).orElse(null);
	}

	public void addEmployee(Employee employee) {
		repositori.save(employee);
	}

	public void updateEmployee(Employee employee) {
		repositori.save(employee);
	}

	public void deleteEmployee(int id) {
		repositori.deleteById(id);
	}
}
