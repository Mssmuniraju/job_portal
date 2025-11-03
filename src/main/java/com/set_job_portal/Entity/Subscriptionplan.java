package com.set_job_portal.Entity;

import javax.persistence.*;

import com.set_job_portal.Enum.Duration;
import com.set_job_portal.Enum.PlanName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="plans")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subscriptionplan
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private PlanName planName;
	private double price;
	private String currency;
	private Duration duration;
	private String features;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PlanName getPlanName() {
		return planName;
	}
	public void setPlanName(PlanName planName) {
		this.planName = planName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	
	

}
