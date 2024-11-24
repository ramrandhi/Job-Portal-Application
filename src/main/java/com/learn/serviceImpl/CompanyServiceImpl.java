package com.learn.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learn.entity.Company;
import com.learn.repository.CompanyRepository;
import com.learn.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	private CompanyRepository companyRepository;
	
	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

	@Override
	public Company getCompanyById(Long id) {
		// TODO Auto-generated method stub
		return companyRepository.findById(id).orElse(null);
	}

	@Override
	public Company saveCompany(Company company) {
		// TODO Auto-generated method stub
		return companyRepository.save(company);
	}

	@Override
	public Company updateCompany(Long id, Company company) {
		// TODO Auto-generated method stub
		Optional<Company> existingCompany = companyRepository.findById(id);
		if (existingCompany.isPresent()) {
			Company com = existingCompany.get();
			com.setName(company.getName());
			com.setDescription(company.getDescription());
			com.setJobs(company.getJobs());
			companyRepository.save(com);
		}

		return company;
	}

	@Override
	public String deleteCompany(Long id) {
		companyRepository.deleteById(id);
		return "Company deleted successfully";
	}

}
