package com.jobfair.jobfair.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Application {

    @EmbeddedId
    private ApplicationId id;

    private LocalDate applyDate;

    @ManyToOne
    @MapsId("jobId")
    @JoinColumn(name = "job_id")
    @JsonBackReference
    private Job job;

    @ManyToOne
    @MapsId("candidateId")
    @JoinColumn(name = "candidate_id")
    @JsonBackReference
    private Candidate candidate;

    // Getters and Setters
    public ApplicationId getId() { return id; }
    public void setId(ApplicationId id) { this.id = id; }

    public LocalDate getApplyDate() { return applyDate; }
    public void setApplyDate(LocalDate applyDate) { this.applyDate = applyDate; }

    public Job getJob() { return job; }
    public void setJob(Job job) { this.job = job; }

    public Candidate getCandidate() { return candidate; }
    public void setCandidate(Candidate candidate) { this.candidate = candidate; }
}
