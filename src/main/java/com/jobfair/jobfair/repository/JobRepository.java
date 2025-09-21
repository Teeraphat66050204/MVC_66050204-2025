package com.jobfair.jobfair.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobfair.jobfair.model.Job;

public interface JobRepository extends JpaRepository<Job, String> {
    // หาตำแหน่งงานตามบริษัท
    List<Job> findByCompany_CompanyId(String companyId);

    // หาตำแหน่งงานที่เปิดรับสมัคร
    List<Job> findByStatus(String status);
}
