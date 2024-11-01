package com.project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController  //η κλάση διαχειρίζεται αιτήματα από το web
@RequestMapping("/api/employers")//το path που θα δέχεται αιτήματα
public class EmployerController {

    


    @Autowired  //ψάχνει το EmployerRepository
    private EmployerRepository employerRepository;//Δημιουργια employerRepository


    @PostMapping
    public Employer addEmployer(@RequestBody Employer employer){
        return employerRepository.save(employer);//Αποθηκευει τον employer στο Repository
    }




    
}
