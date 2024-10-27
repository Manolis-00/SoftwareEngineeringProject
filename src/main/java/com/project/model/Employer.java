package com.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
}
