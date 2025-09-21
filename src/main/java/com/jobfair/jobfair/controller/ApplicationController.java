package com.jobfair.jobfair.controller;

import com.jobfair.jobfair.model.Application;
import com.jobfair.jobfair.model.Candidate;
import com.jobfair.jobfair.model.Job;
import com.jobfair.jobfair.service.ApplicationService;
import com.jobfair.jobfair.service.CandidateService;
import com.jobfair.jobfair.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/jobs")
public class ApplicationController {

    private final ApplicationService applicationService;
    private final CandidateService candidateService;
    private final JobService jobService;

    public ApplicationController(ApplicationService applicationService,
                                 CandidateService candidateService,
                                 JobService jobService) {
        this.applicationService = applicationService;
        this.candidateService = candidateService;
        this.jobService = jobService;
    }

    // ✅ หน้าสมัครงาน
    @GetMapping("/apply")
    public String applyPage(@RequestParam String jobId, @RequestParam String candidateId, Model model) {
        Job job = jobService.getJobById(jobId);
        Candidate candidate = candidateService.getCandidateById(candidateId);
        model.addAttribute("job", job);
        model.addAttribute("candidate", candidate);
        return "apply";
    }

    // ✅ กดยืนยันสมัครงาน
    @PostMapping("/confirm-apply")
    public String confirmApply(@RequestParam String jobId, @RequestParam String candidateId) {
        Candidate candidate = candidateService.getCandidateById(candidateId);
        Job job = jobService.getJobById(jobId);

        Application app = new Application();
        app.setJob(job);
        app.setCandidate(candidate);
        app.setApplyDate(LocalDate.now());

        applicationService.save(app);

        return "redirect:/jobs/open?candidateId=" + candidateId;
    }
}
