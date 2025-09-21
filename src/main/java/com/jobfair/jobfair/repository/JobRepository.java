package com.jobfair.jobfair.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobfair.jobfair.model.Job;

public interface JobRepository extends JpaRepository<Job, String> {
   
    List<Job> findByCompany_CompanyId(String companyId);

   
    List<Job> findByStatus(String status);
}
