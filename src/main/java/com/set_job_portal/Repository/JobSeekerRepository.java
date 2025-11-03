package com.set_job_portal.Repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.set_job_portal.Entity.JobSeeker;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker,Long>
{
	Optional<JobSeeker>findByEmail(String email);

}
