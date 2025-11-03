package com.set_job_portal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.set_job_portal.DTO.JobPostDTO;
import com.set_job_portal.Service.JobPostService;

@RestController
@RequestMapping("/api/jobPost")
public class JobPostController
{
	@Autowired
	private JobPostService jobPostService;
	
	@PostMapping
	public ResponseEntity<JobPostDTO>createJobs(@RequestBody JobPostDTO dto)
	{
		return ResponseEntity.ok(jobPostService.createJob(dto));
	}
	@GetMapping("/jobPost/{companyName}")
	public ResponseEntity<List<JobPostDTO>>getJobByCompanyName(@PathVariable String companyName)
	{
		return ResponseEntity.ok(jobPostService.findJobByCompanyName(companyName));
		
	}
	
	@GetMapping("/jobPost/{recruiterEmail}")
	public ResponseEntity<List<JobPostDTO>>getJobByRecruiterEmail(@PathVariable String recruiterEmail)
	{
		return ResponseEntity.ok(jobPostService.findByRecruiterEmail(recruiterEmail));
	}
	
	@GetMapping("/jobPost/{jobTitle}")
	public ResponseEntity<List<JobPostDTO>>getJobByJobTitle(@PathVariable String jobTitle)
	{
		return ResponseEntity.ok(jobPostService.findJobByJobTitle(jobTitle));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
