package com.jobfair.jobfair.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jobfair.jobfair.model.Job;
import com.jobfair.jobfair.model.JobStatus;
import com.jobfair.jobfair.repository.JobRepository;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }


    public List<Job> getOpenJobsSorted() {
        return jobRepository.findAll()
                .stream()
                .filter(job -> job.getStatus() == JobStatus.OPEN)
                .sorted(Comparator.comparing(Job::getTitle)
                        .thenComparing(job -> job.getCompany().getName())
                        .thenComparing(Job::getDeadline))
                .collect(Collectors.toList());
    }

    public Job getJobById(String id) {
        Optional<Job> job = jobRepository.findById(id);
        return job.orElse(null);
    }
}
