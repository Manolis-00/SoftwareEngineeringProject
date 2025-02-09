package com.project.mavenApplication.repositories;

import com.project.mavenApplication.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
