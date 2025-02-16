package com.project.mavenApplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employer_id")
    private Long employerId;
    private String username;
    private String password;
    private String city;
    private String companyName;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employee> employees = new HashSet<>();

    @ManyToMany(mappedBy = "employers")
    private Set<Job> jobs = new HashSet<>();

    @Override
    public String toString() {
        return "Employer{" +
                "employerId=" + employerId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", employees=" + employees +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employer employer)) return false;

        return Objects.equals(employerId, employer.employerId);
    }

    @Override
    public int hashCode() {
        return getEmployerId() != null ? getEmployerId().hashCode() : 0;
    }
}
