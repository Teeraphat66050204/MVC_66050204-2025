package com.jobfair.jobfair.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobfair.jobfair.model.Application;
import com.jobfair.jobfair.model.ApplicationId;

public interface ApplicationRepository extends JpaRepository<Application, ApplicationId> {
    List<Application> findByCandidate_CandidateId(String candidateId);
    List<Application> findByJob_JobId(String jobId);
}
