package com.jobfair.jobfair.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobfair.jobfair.model.Application;
import com.jobfair.jobfair.repository.ApplicationRepository;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    // ✅ ใช้โดย ApplicationController
    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    // ✅ ใช้โดย AdminController & CandidateController
    public List<Application> getApplicationsByCandidateId(String candidateId) {
        return applicationRepository.findAll()
                .stream()
                .filter(app -> app.getCandidate().getCandidateId().equals(candidateId))
                .toList();
    }
}
