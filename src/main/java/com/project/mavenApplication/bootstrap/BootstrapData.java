package com.project.mavenApplication.bootstrap;

import com.project.mavenApplication.models.Employee;
import com.project.mavenApplication.models.Employer;
import com.project.mavenApplication.repositories.EmployeeRepository;
import com.project.mavenApplication.repositories.EmployerRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final EmployerRepository employerRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        Employer somethingLlc = new Employer();
        somethingLlc.setUsername("something#");
        somethingLlc.setPassword("6788900");
        somethingLlc.setCity("London");
        somethingLlc.setCompanyName("Something");

        Employee eric = new Employee();
        eric.setUsername("Eric");
        eric.setPassword("123345");
        eric.setCity("Birmingham");
        eric.setFirstName("Eric");
        eric.setLastName("Johnson");
        eric.setEmployer(somethingLlc);

        Employee bruce = new Employee();
        bruce.setUsername("Bruce");
        bruce.setPassword("dasdas");
        bruce.setCity("York");
        bruce.setFirstName("Bruce");
        bruce.setLastName("Muller");
        bruce.setEmployer(somethingLlc);

        /*
        Set<Employee> employees = new HashSet<>();
        employees.add(eric);
        employees.add(bruce);
        somethingLlc.setEmployees(employees);
         */

        Employer somethingLlcSaved = employerRepository.save(somethingLlc);
        Employee ericSaved = employeeRepository.save(eric);
        Employee bruceSaved = employeeRepository.save(bruce);

        somethingLlcSaved.getEmployees().add(ericSaved);
        somethingLlcSaved.getEmployees().add(bruceSaved);

        System.out.println("In Bootstrap");
        System.out.println("Employees Count: " + employeeRepository.count());
        System.out.println("Employers Count: " + employerRepository.count());
    }
}
