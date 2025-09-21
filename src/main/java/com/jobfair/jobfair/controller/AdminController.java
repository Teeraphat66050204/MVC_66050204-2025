package com.jobfair.jobfair.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jobfair.jobfair.model.Application;
import com.jobfair.jobfair.model.Candidate;
import com.jobfair.jobfair.service.ApplicationService;
import com.jobfair.jobfair.service.CandidateService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final CandidateService candidateService;
    private final ApplicationService applicationService;

    public AdminController(CandidateService candidateService, ApplicationService applicationService) {
        this.candidateService = candidateService;
        this.applicationService = applicationService;
    }


    @GetMapping("/candidates")
    public String getAllCandidates(Model model) {
        List<Candidate> candidates = candidateService.getAllCandidatesSortedByName();
        model.addAttribute("candidates", candidates);
        return "candidates";
    }


    @GetMapping("/candidate/{id}")
    public String getCandidateDetails(@PathVariable String id, Model model) {
        Candidate candidate = candidateService.getCandidateById(id);
        List<Application> applications = applicationService.getApplicationsByCandidateId(id);
        model.addAttribute("candidate", candidate);
        model.addAttribute("applications", applications);
        return "candidate-details";
    }
}
