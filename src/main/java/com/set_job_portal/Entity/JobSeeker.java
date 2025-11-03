package com.set_job_portal.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jobseekers")
public class JobSeeker 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jsid;
	private String jsName;
	@Column(unique = true)
	private String jsEmailid;
	private long jsPhoneNumber;
	
	private String jsUniversityName;
	private String jsCourse_Stream;
	private String jsPassingYear;
	
	private String jsResumeURL;
	private boolean active = true;
	
	
	public JobSeeker() {
		super();
	}
	public Long getJsid() {
		return jsid;
	}
	public void setJsid(Long jsid) {
		this.jsid = jsid;
	}
	public String getJsName() {
		return jsName;
	}
	public void setJsName(String jsName) {
		this.jsName = jsName;
	}
	public String getJsEmailid() {
		return jsEmailid;
	}
	public void setJsEmailid(String jsEmailid) {
		this.jsEmailid = jsEmailid;
	}
	public long getJsPhoneNumber() {
		return jsPhoneNumber;
	}
	public void setJsPhoneNumber(long jsPhoneNumber) {
		this.jsPhoneNumber = jsPhoneNumber;
	}
	public String getJsUniversityName() {
		return jsUniversityName;
	}
	public void setJsUniversityName(String jsUniversityName) {
		this.jsUniversityName = jsUniversityName;
	}
	public String getJsCourse_Stream() {
		return jsCourse_Stream;
	}
	public void setJsCourse_Stream(String jsCourse_Stream) {
		this.jsCourse_Stream = jsCourse_Stream;
	}
	public String getJsPassingYear() {
		return jsPassingYear;
	}
	public void setJsPassingYear(String jsPassingYear) {
		this.jsPassingYear = jsPassingYear;
	}
	public String getJsResumeURL() {
		return jsResumeURL;
	}
	public void setJsResumeURL(String jsResumeURL) {
		this.jsResumeURL = jsResumeURL;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	

}
