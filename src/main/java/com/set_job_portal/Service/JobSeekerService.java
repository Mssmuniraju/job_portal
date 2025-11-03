package com.set_job_portal.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.set_job_portal.DTO.JobSeekerDTO;
import com.set_job_portal.Entity.JobSeeker;
import com.set_job_portal.Repository.JobSeekerRepository;

@Service
public class JobSeekerService
{
	@Autowired
	private JobSeekerRepository jobSeekerRepository;
	
	
	
	public JobSeekerDTO createOrUpdate(JobSeekerDTO dto)
	{
		JobSeeker jobSeeker = new JobSeeker();
		jobSeeker.setJsid(dto.id);
		jobSeeker.setJsName(dto.name);
		jobSeeker.setJsEmailid(dto.email);
		jobSeeker.setJsPhoneNumber(dto.phone);
		jobSeeker.setJsUniversityName(dto.universityName);
		jobSeeker.setJsCourse_Stream(dto.course);
		jobSeeker.setJsPassingYear(dto.passingYear);
		jobSeeker.setJsResumeURL(dto.resumeURL);
		
		JobSeeker saved  = jobSeekerRepository.save(jobSeeker);
		
		return dto;
		
	}
	
	public JobSeekerDTO getJobSeekerByEmail(String email)
	{
		Optional<JobSeeker> jobSeeker = jobSeekerRepository.findByEmail(email);
		
		return jobSeeker.map(jobSeek->{
			JobSeekerDTO  dto= new JobSeekerDTO();
			
			dto.setId(jobSeek.getJsid());
			dto.setName(jobSeek.getJsName());
			dto.setEmail(jobSeek.getJsEmailid());
			dto.setPhone(jobSeek.getJsPhoneNumber());
			dto.setUniversityName(jobSeek.getJsUniversityName());
			dto.setCourse(jobSeek.getJsCourse_Stream());
			dto.setPassingYear(jobSeek.getJsPassingYear());
			dto.setResumeURL(jobSeek.getJsResumeURL());
			
			return dto;
		}).orElse(null);
		
	}
	
}


