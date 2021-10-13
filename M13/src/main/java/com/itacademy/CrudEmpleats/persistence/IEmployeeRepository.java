package com.itacademy.CrudEmpleats.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.itacademy.CrudEmpleats.domain.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}