package com.set_job_portal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.set_job_portal.DTO.RecruiterDTO;
import com.set_job_portal.Entity.Recruiter;
import com.set_job_portal.Repository.RecruiterRepository;

@Service
public class RecruiterService 
{
	@Autowired
	private RecruiterRepository recruiterRepository;
	
	
	public Recruiter createRecruiterProfile(String recruiterEmail ,RecruiterDTO dto )
	{
		Recruiter recruiter = recruiterRepository.findByEmail(recruiterEmail).orElse(new Recruiter());
		
		recruiter.setRecruiterEmail(dto.getRecruiterEmail());
		recruiter.setRecruiterPhone(dto.getRecruiterPhone());
		recruiter.setCompanyName(dto.getCompanyName());
		recruiter.setCompanyWebsite(dto.getCompanyWebsite());
		
		return recruiterRepository.save(recruiter);
	}
	
	public Recruiter getRecruiterByCompanyName(String companyName)
	{
		return recruiterRepository.findByCompanyName(companyName).orElseThrow(()-> new RuntimeException("Recruiter no found"));
		
	}

}
