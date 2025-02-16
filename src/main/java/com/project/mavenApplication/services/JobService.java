package com.project.mavenApplication.services;

import com.project.mavenApplication.models.Job;

public interface JobService {

    Iterable<Job> findAll();
}
