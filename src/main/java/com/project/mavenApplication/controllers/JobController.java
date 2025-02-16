package com.project.mavenApplication.controllers;

import com.project.mavenApplication.services.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @RequestMapping("/jobs")
    public String getJobs(Model model){
        model.addAttribute("jobs", jobService.findAll());
        return "jobs";
    }
}
