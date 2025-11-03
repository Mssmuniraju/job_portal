package com.set_job_portal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.set_job_portal.Entity.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course,Long>
 {
	List<Course>findByActiveTrue();

}
