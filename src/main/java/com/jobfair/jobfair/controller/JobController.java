package com.jobfair.jobfair.controller;

import com.jobfair.jobfair.model.Job;
import com.jobfair.jobfair.model.Candidate;
import com.jobfair.jobfair.service.JobService;
import com.jobfair.jobfair.service.CandidateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;
    private final CandidateService candidateService;

    public JobController(JobService jobService, CandidateService candidateService) {
        this.jobService = jobService;
        this.candidateService = candidateService;
    }

    // ✅ หน้าตำแหน่งงานที่เปิด (Candidate Home)
    @GetMapping("/open")
    public String getOpenJobs(@RequestParam(required = false) String candidateId, Model model) {
        List<Job> jobs = jobService.getOpenJobsSorted();
        model.addAttribute("jobs", jobs);
        model.addAttribute("candidateId", candidateId); // เพื่อให้กดสมัครได้
        return "jobs";
    }
}
