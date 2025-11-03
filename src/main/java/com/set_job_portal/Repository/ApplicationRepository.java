package com.set_job_portal.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.set_job_portal.Entity.Application;
import com.set_job_portal.Enum.JobType;



@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>
{
	List<Application>findByJobSeekerEmail(String jobSeekerEmail);
	List<Application>findByRecruiterEmail(String recruiterEmail);
	Optional<Application>findByJobSeekerEmailAndJobId(String jobSeekerEmail,Long JobId);
	List<Application>findByJobTitle(String jobTitle);
	List<Application>findByJobType(JobType jobType);
	

}
