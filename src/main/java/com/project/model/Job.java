package com.project.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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


    @ManyToOne // Πολλές δουλειές για έναν employer
    @JoinColumn(name = "employer_id", nullable = false)
    private Employer employer;

    @OneToMany(mappedBy = "job") // Μια δουλειά για πολλούς employees
    private Set<Employee> employees; 
}
