package com.project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController  //η κλάση διαχειρίζεται αιτήματα από το web
@RequestMapping("/api/employees")//το path που θα δέχεται αιτήματα
public class EmployeeController {

    
    @Autowired  //ψάχνει το EmployeeRepository 
    private EmployeeRepository employeeRepository;//Δημιουργία employeeRepository

    @Autowired  //ψάχνει το EmployerRepository
    private EmployerRepository employerRepository;//Δημιουργια employerRepository


    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);//Αποθηκευει τον employee στο Repository
    }



        @PostMapping("/{employerId}")
    public Employee addEmployerToEmployee(@PathVariable Long employerId, @RequestBody Employee employee) {//βρισκει τον employer που θα έχει ο employee
        Employer employer = employerRepository.findById(employerId)//ψαχνει τον employer από το ID
        .orElseThrow(() -> new RuntimeException("Employer not found"));
        employee.setEmployer(employer);//Προσθέτει τον εργοδότη του υπαλλήλου
        employer.getEmployees().add(employee);//Προσθέτει τον υπάλληλο στο set των employees που διαθέτει ο εργοδότης
        employerRepository.save(employer);
        return employeeRepository.save(employee); 
    }
    
}
