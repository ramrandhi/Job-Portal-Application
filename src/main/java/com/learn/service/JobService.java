package com.learn.service;

import java.util.List;

import com.learn.entity.Job;

public interface JobService {

	public List<Job> getAll();

	public String createJob(Job job);

	public Job findJobById(Long id);

	public Boolean deleteJobById(Long id);

	public boolean updateJobById(Long id, Job updatedJob);

}
