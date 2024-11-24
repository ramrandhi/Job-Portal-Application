package com.learn.entity;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//{
//
//	  "name" : "Company 1",
//	  "description" : "Description 1"
//	}


@Entity
@Table(name = "COMPANY")
public class Company implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3838276161997448761L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "company")
	@Cascade(CascadeType.ALL)
	@JsonManagedReference
	private List<Job> jobs;
	
	@OneToMany(mappedBy = "company")
	@Cascade(CascadeType.ALL)
	@JsonManagedReference
	private List<Review> reviews;

	public Company() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", description=" + description + ", jobs=" + jobs + "]";
	}
}
