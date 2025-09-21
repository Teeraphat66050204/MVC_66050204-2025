package com.jobfair.jobfair.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jobfair.jobfair.model.Candidate;
import com.jobfair.jobfair.repository.CandidateRepository;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    // ✅ ใช้โดย AdminController
    public List<Candidate> getAllCandidatesSortedByName() {
        return candidateRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Candidate::getFirstName)
                        .thenComparing(Candidate::getLastName))
                .collect(Collectors.toList());
    }

    public Candidate getCandidateById(String id) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        return candidate.orElse(null);
    }
}
