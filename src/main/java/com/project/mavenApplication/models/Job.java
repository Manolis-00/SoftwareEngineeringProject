package com.project.mavenApplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_id")
    private Long jobId;
    private String title;
    private String description;
    private String city;
    private String yearlyGrossSalaryRange;
    private String requirements;
    private String status;

    @OneToMany(mappedBy = "job")
    private Set<Employee> employees = new HashSet<>();

    @ManyToMany
    private Set<Employer> employers = new HashSet<>();
}
