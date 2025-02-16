package com.project.mavenApplication.repositories;

import com.project.mavenApplication.models.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long> {
}
