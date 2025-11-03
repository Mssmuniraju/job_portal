package com.set_job_portal.DTO;

import java.time.LocalDate;

public class JobPostDTO
{
	public Long id;
	public Long recruiterId;
	private String recruiterEmailId;
	private String companyName;
	public String jobTitle;
	public String jobDescription;
	public String jobType;
	public String jobcatagory;
	public String jobLocation;
	
	public boolean remote;
	public LocalDate postedDate = LocalDate.now();
	public boolean active = true;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRecruiterId() {
		return recruiterId;
	}
	public void setRecruiterId(Long recruiterId) {
		this.recruiterId = recruiterId;
	}
	public String getRecruiterEmailId() {
		return recruiterEmailId;
	}
	public void setRecruiterEmailId(String recruiterEmailId) {
		this.recruiterEmailId = recruiterEmailId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getJobcatagory() {
		return jobcatagory;
	}
	public void setJobcatagory(String jobcatagory) {
		this.jobcatagory = jobcatagory;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public boolean isRemote() {
		return remote;
	}
	public void setRemote(boolean remote) {
		this.remote = remote;
	}
	public LocalDate getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	

}
