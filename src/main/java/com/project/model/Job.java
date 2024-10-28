package com.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Job {

    @Id
    @GeneratedValue
    private Long id;

    private String jobName;

    private String salary;

    private String city;

    private String description;
}
