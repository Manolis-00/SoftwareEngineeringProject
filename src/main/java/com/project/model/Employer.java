package com.project.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Employer {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String city;

    private String companyName;

    //Ενας εργοδοτης μπορεί να έχει πολλούς υπάλληλους
    @OneToMany(mappedBy = "employer")//το mappedBy συνδέει το set με την κλαση Employee.
    private Set<Employee> employees;

    //Ενας εργοδοτης μπορεί να προσφέρει πολλές δουλειές
    @OneToMany(mappedBy = "employer") 
    private Set<Job> jobs; 
}
