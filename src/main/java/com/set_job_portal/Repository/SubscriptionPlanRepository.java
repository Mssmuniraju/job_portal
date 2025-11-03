package com.set_job_portal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.set_job_portal.Entity.Subscriptionplan;

@Repository
public interface SubscriptionPlanRepository extends JpaRepository<Subscriptionplan, Long>
{
	

}
