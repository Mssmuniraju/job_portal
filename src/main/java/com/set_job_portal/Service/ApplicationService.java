package com.set_job_portal.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.set_job_portal.DTO.ApplicationDTO;
import com.set_job_portal.Entity.Application;
import com.set_job_portal.Enum.JobType;
import com.set_job_portal.Enum.ApplicationStatus;
import com.set_job_portal.Repository.ApplicationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplicationService
{
	@Autowired
	private ApplicationRepository appRepo;
	
	public String apply(ApplicationDTO dto)
	{
		if(appRepo.findByJobSeekerEmailAndJobId(dto.getJobSeekerEmail(), dto.getJobId()).isPresent())
				{
		           throw new RuntimeException("You Already have this job");	
				}
		Application app = new Application();
		app.setJobId(dto.getJobId());
		app.setJobSeekerName(dto.getJobSeekerName());
		app.setJobSeekerEmail(dto.getJobSeekerEmail());
		app.setJobTitle(dto.getJobTitle());
		app.setJobType(dto.getJobTypel());
		app.setRecruiterEmail(dto.getRecruiterEmail());
		app.setStatus(dto.getStatus());
		app.setAppliedAt(dto.getAppliedAt());
		appRepo.save(app);
		
		return "you just applied this job";	
		
	}
	
	public List<ApplicationDTO>getByJobSeekerEmail(String jobSeekerEmail)
	{
		return appRepo.findByJobSeekerEmail(jobSeekerEmail).stream().map(this::mapToDTO).collect(Collectors.toList());	
	}
	
	public List<ApplicationDTO>getByRecruiterEmail(String recruiterEmail)
	{
		return appRepo.findByRecruiterEmail(recruiterEmail).stream().map(this::mapToDTO).collect(Collectors.toList());
		
	}
	public List<ApplicationDTO>getByJobTitle(String jobTitle) 
	{
		return appRepo.findByJobTitle(jobTitle).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<ApplicationDTO>getByJobType(JobType jobType) 
	{
		return appRepo.findByJobType(jobType).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public void updateStatus(Long id,ApplicationStatus status)
	{
		Application app = appRepo.findById(id).orElseThrow(()-> new RuntimeException("Application not found"));
		app.setStatus(status);
		appRepo.save(app);
	}
	
	private ApplicationDTO mapToDTO(Application app)
	{
		ApplicationDTO dto = new ApplicationDTO();
		dto.setJobId(app.getJobId());
		dto.setJobSeekerEmail(app.getJobSeekerEmail());
		dto.setJobSeekerName(app.getJobSeekerName());
		dto.setRecruiterEmail(app.getRecruiterEmail());
		dto.setJobTypel(app.getJobType());
		dto.setJobTitle(app.getJobTitle());
		dto.setStatus(app.getStatus());
		dto.setAppliedAt(app.getAppliedAt());
		
		return dto;
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}
