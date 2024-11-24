package com.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
