package com.jobfair.jobfair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobfair.jobfair.model.Company;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
