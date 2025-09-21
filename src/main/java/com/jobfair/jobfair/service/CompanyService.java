package com.jobfair.jobfair.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobfair.jobfair.model.Company;
import com.jobfair.jobfair.repository.CompanyRepository;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(String id) {
        return companyRepository.findById(id).orElse(null);
    }

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public void deleteCompany(String id) {
        companyRepository.deleteById(id);
    }
}
