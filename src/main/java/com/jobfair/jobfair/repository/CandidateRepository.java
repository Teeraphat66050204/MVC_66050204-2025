package com.jobfair.jobfair.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobfair.jobfair.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, String> {
    // เรียงผู้สมัครตามชื่อ
    List<Candidate> findAllByOrderByFirstNameAsc();
}
