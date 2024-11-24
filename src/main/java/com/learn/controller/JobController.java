package com.learn.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entity.Job;
import com.learn.service.JobService;

@RestController
@RequestMapping(value="/jobs")
public class JobController {

	private JobService jobService;

	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	@GetMapping
	public List<Job> findAll() {
		return jobService.getAll();
	}

	@PostMapping
	public ResponseEntity<String> createJob(@RequestBody Job job) {
		jobService.createJob(job);
		return new ResponseEntity<>("Job added successfully!", HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Job> findJobById(@PathVariable("id") Long id) {
		Job job = jobService.findJobById(id);
		if (job != null)
			return new ResponseEntity<>(job, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJobById(@PathVariable("id") Long id) {
		Boolean delete = jobService.deleteJobById(id);
		if (delete)
			return new ResponseEntity<>("Job With Id Delete Successfully", HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateJobById(@PathVariable("id") Long id, @RequestBody Job updatedJob){
		boolean updated = jobService.updateJobById(id, updatedJob);
		if(updated)
			return new ResponseEntity<>("Job updated successfully",HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
