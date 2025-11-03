package com.set_job_portal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.set_job_portal.Entity.JobPost;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Long>
{
	List<JobPost>findByRecruiterEmailid(String recruiterEmailid);
	List<JobPost>findByJobTitle(String jobTitle);
	List<JobPost>findByCompanyName(String companyName);
	

}
