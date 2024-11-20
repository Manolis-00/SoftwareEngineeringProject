package com.project.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired  //ψάχνει το JobRepository
    private JobRepository jobRepository;//Δημιουργια jobRepository

    @Autowired //ψάχνει το employeeRepository
    private EmployeeRepository employeeRepository;//Δημιουργια employeeRepository

 // Δημιουργία νέας θέσης εργασίας
    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobRepository.save(job); // Αποθηκεύει στο database
    }

// Επιστροφή των θέσεων εργασίας
    @GetMapping
    public Iterable<Job> getAllJobs() {
        return jobRepository.findAll(); // Επιστρέφει όλα τα jobs
    }


//Δήλωση ενδιαφέροντος για θέση εργασίας
    @PostMapping("/{jobId}/interest/{employeeId}")
    public String expressInterest(@PathVariable Long jobId, @PathVariable Long employeeId) {
        Job job = jobRepository.findById(jobId) // Εύρεση της θέσης εργασίας από το id του job
        .orElseThrow(() -> new RuntimeException("Job not found"));


        Employee employee = employeeRepository.findById(employeeId)// Εύρεση του υπαλλήλου από το id του employee
        .orElseThrow(() -> new RuntimeException("Employee not found"));

        
        job.getEmployees().add(employee);// Προσθήκη του υπαλλήλου στη λίστα των υπαλλήλων που ενδιαφέρονται για κάποιο job
        jobRepository.save(job); // Αποθήκευση του αντικειμένου
        return "Employee is interested for the job";
    }


}
