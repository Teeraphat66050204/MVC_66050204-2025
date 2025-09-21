package com.jobfair.jobfair.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobfair.jobfair.model.Company;
import com.jobfair.jobfair.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return service.getAllCompanies();
    }

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable String id) {
        return service.getCompanyById(id);
    }

    @PostMapping
    public Company addCompany(@RequestBody Company company) {
        return service.saveCompany(company);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable String id) {
        service.deleteCompany(id);
    }
}
