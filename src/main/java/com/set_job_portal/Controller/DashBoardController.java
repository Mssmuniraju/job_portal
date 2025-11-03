package com.set_job_portal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.set_job_portal.DTO.ApplicationStatusDTO;
import com.set_job_portal.DTO.CourseStatusDTO;
import com.set_job_portal.DTO.JobPostStatusDTO;
import com.set_job_portal.DTO.SubscriptionStatusDTO;
import com.set_job_portal.DTO.UserStatusDTO;
import com.set_job_portal.Service.DashBoardService;

@RestController
@RequestMapping("/api/dashBoarads")
public class DashBoardController
{
	@Autowired
	private DashBoardService dashBoardService;
	
	
	@GetMapping("/jobs")
	public ResponseEntity<JobPostStatusDTO>fetchJobs(){
		return ResponseEntity.ok(dashBoardService.fetechJobStatus());
	}

	@GetMapping("/applications")
	public ResponseEntity<ApplicationStatusDTO>fetchApplication(){
		return ResponseEntity.ok(dashBoardService.fetchApplicationStatus());
	}
	
	@GetMapping("/users")
	public ResponseEntity<UserStatusDTO>fetchUsers(){
		return ResponseEntity.ok(dashBoardService.fetchUsersStatus());
	}
	
	@GetMapping("/courses")
	public ResponseEntity<CourseStatusDTO>getCourseStatus()
	{
		return ResponseEntity.ok(dashBoardService.fetchCourseStatus());
	}
	
	@GetMapping("/subscriptions")
	public ResponseEntity<SubscriptionStatusDTO>getSubscriptionStatus()
	{
		return ResponseEntity.ok(dashBoardService.fetchSubscriptionStatus());
	}
	

}
