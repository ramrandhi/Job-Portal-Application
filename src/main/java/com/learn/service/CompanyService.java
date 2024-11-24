package com.learn.service;

import java.util.List;

import com.learn.entity.Company;

public interface CompanyService {

	List<Company> getAllCompanies();

	Company getCompanyById(Long id);

	Company saveCompany(Company company);

	Company updateCompany(Long id, Company company);

	String deleteCompany(Long id);

}
