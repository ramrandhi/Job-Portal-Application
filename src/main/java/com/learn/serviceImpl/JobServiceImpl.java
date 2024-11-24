package com.learn.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learn.entity.Job;
import com.learn.repository.JobRepository;
import com.learn.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	private JobRepository jobRepository;

	public JobServiceImpl(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	private List<Job> jobs = new ArrayList<>();
	private Long nextId = 1L;

	@Override
	public List<Job> getAll() {
		return jobRepository.findAll();
	}

	@Override
	public String createJob(Job job) {
//		job.setId(nextId++);
//		jobs.add(job);
		jobRepository.save(job);
		return "Job added successfully!";
	}

	@Override
	public Job findJobById(Long id) {
//		for (Job j : jobs) {
//			if (j.getId() == id) {
//				return j;
//			}
//		}
		return jobRepository.findById(id).orElse(null);

	}

	@Override
	public Boolean deleteJobById(Long id) {
//		for(Job j : jobs) {
//			if(j.getId() == id) {
//				jobs.remove(j);
//				return true;
//			}
//		}
//		Iterator<Job> iterator = jobs.iterator();
//		while (iterator.hasNext()) {
//			Job job = iterator.next();
//			if (job.getId() == id) {
//				jobs.remove(job);
//				return true;
//			}
//		}

		try {
			jobRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateJobById(Long id, Job updatedJob) {
//		Iterator<Job> iterator = jobs.iterator();
//		while (iterator.hasNext()) {
//			Job job = iterator.next();
//			if (job.getId() == id) {
//				job.setTitle(updatedJob.getTitle());
//				job.setDescription(updatedJob.getDescription());
//				job.setMinSalary(updatedJob.getMinSalary());
//				job.setMaxSalary(updatedJob.getMaxSalary());
//				job.setLocation(updatedJob.getLocation());
//				return true;
//			}
//		}
		
		Optional<Job> jobOptional = jobRepository.findById(id);
		if(jobOptional.isPresent()) {
			Job job = jobOptional.get();
			job.setTitle(updatedJob.getTitle());
			job.setDescription(updatedJob.getDescription());
			job.setMinSalary(updatedJob.getMinSalary());
			job.setMaxSalary(updatedJob.getMaxSalary());
			job.setLocation(updatedJob.getLocation());
			jobRepository.save(job);
			return true;
		}
		return false;
	}

}
