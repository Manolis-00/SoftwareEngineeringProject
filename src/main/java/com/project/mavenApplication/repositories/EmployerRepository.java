package com.project.mavenApplication.repositories;

import com.project.mavenApplication.models.Employer;
import org.springframework.data.repository.CrudRepository;

public interface EmployerRepository extends CrudRepository<Employer, Long> {

}
