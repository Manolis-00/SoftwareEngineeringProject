package com.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String city;

    private String firstName;

    private String lastName;


    @ManyToOne // Πολλοί employees θα έχουν ένα job
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne
    @JoinColumn(name = "employer_id", nullable = false) //Δημιουργει στήλη με το id του employer (δεν μπορεί να είναι null)
    private Employer employer;



}
