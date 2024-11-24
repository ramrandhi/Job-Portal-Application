package com.learn.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entity.Company;
import com.learn.service.CompanyService;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController {

	private CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	@GetMapping
	public List<Company> getAllCompanies() {
		return companyService.getAllCompanies();
	}

	@GetMapping("/{id}")
	public Company getCompanyById(@PathVariable("id") Long id) {
		return companyService.getCompanyById(id);
	}

	@PostMapping
	public Company saveCompany(@RequestBody Company company) {
		return companyService.saveCompany(company);
	}

	@PutMapping("/{id}")
	public Company updateCompany(@PathVariable("id") Long id, @RequestBody Company company) {
		return companyService.updateCompany(id, company);
	}

	@DeleteMapping("/{id}")
	public String deleteCompany(@PathVariable("id") Long id) {
		return companyService.deleteCompany(id);
	}

}
