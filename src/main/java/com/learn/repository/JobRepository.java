package com.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long>{

}
