package com.jobfair.jobfair.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class ApplicationId implements Serializable {

    private String jobId;
    private String candidateId;

    public ApplicationId() {}

    public ApplicationId(String jobId, String candidateId) {
        this.jobId = jobId;
        this.candidateId = candidateId;
    }

  
    public String getJobId() { return jobId; }
    public void setJobId(String jobId) { this.jobId = jobId; }

    public String getCandidateId() { return candidateId; }
    public void setCandidateId(String candidateId) { this.candidateId = candidateId; }

   
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApplicationId)) return false;
        ApplicationId that = (ApplicationId) o;
        return Objects.equals(jobId, that.jobId) &&
               Objects.equals(candidateId, that.candidateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, candidateId);
    }
}
