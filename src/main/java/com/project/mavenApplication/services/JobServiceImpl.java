package com.project.mavenApplication.services;

import com.project.mavenApplication.models.Job;
import com.project.mavenApplication.repositories.JobRepository;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Iterable<Job> findAll() {
        return jobRepository.findAll();
    }
}
