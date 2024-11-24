package com.learn.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//
//{
//	  "title": "software engineer needed",
//	  "description": "Test Description",
//	  "minSalary": "30000",
//	  "maxSalary": "40000",
//	  "location": "hyderabad",
//	  "company": {
//	    "name": "Company 1",
//	    "description": "Description 1"
//	  }
//	}



@Entity
@Table(name="JOB")
public class Job implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1019298864202945912L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private String minSalary;
	private String maxSalary;
	private String location;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Company company;
	
	public Job() {}

	public Job(Long id, String title, String description, String minSalary, String maxSalary, String location) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}

	public String getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", description=" + description + ", minSalary=" + minSalary
				+ ", maxSalary=" + maxSalary + ", location=" + location + "]";
	}
}
