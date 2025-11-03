package com.set_job_portal.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.set_job_portal.Entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>
{
	Optional<User>finalByEmail(String email);
	boolean existByUserName(String name);
	boolean existByUserEmail(String email);
	

}
