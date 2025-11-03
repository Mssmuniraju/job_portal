package com.set_job_portal.DTO;

import java.time.LocalDateTime;

import com.set_job_portal.Enum.JobType;
import com.set_job_portal.Enum.ApplicationStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationDTO
{
	private String jobSeekerName;
	private String jobSeekerEmail;
	private String recruiterEmail;
	private Long jobId;
	private String jobTitle;
	private JobType jobTypel;
	private ApplicationStatus status;
	private LocalDateTime appliedAt;
	
	
	public String getJobSeekerName() {
		return jobSeekerName;
	}
	public void setJobSeekerName(String jobSeekerName) {
		this.jobSeekerName = jobSeekerName;
	}
	public String getJobSeekerEmail() {
		return jobSeekerEmail;
	}
	public void setJobSeekerEmail(String jobSeekerEmail) {
		this.jobSeekerEmail = jobSeekerEmail;
	}
	public String getRecruiterEmail() {
		return recruiterEmail;
	}
	public void setRecruiterEmail(String recruiterEmail) {
		this.recruiterEmail = recruiterEmail;
	}
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public JobType getJobTypel() {
		return jobTypel;
	}
	public void setJobTypel(JobType jobTypel) {
		this.jobTypel = jobTypel;
	}
	public ApplicationStatus getStatus() {
		return status;
	}
	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}
	public LocalDateTime getAppliedAt() {
		return appliedAt;
	}
	public void setAppliedAt(LocalDateTime appliedAt) {
		this.appliedAt = appliedAt;
	}
	
	
	
	
	

}
