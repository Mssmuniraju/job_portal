package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@Configuration
@SpringBootApplication

@EntityScan(basePackages = "com.set_job_portal.Entity")
@EnableJpaRepositories(basePackages = "com.set_job_portal.Repository")
@ComponentScan(basePackages = "com")


public class SetJobPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SetJobPortalApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

}
