package com.project.model;

import org.springframework.data.jpa.repository.JpaRepository;
//το JpaRepository δίνει αυτόματα τις βασικές CRUD  μεθόδους
public interface EmployerRepository extends JpaRepository<Employer, Long>{//το Long είναι ο τυπος του primary key(ID employer)

}
