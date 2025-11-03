package com.set_job_portal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.set_job_portal.DTO.LoginRequestDTO;
import com.set_job_portal.DTO.RegisterRequestDTO;
import com.set_job_portal.Entity.User;
import com.set_job_portal.Repository.UserRepository;
import com.set_job_portal.Security.JWTUtil;

@Service
public class AuthService 
{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JWTUtil jwtUtil;
	
	public String register(RegisterRequestDTO dto)
	{
		if(userRepository.existByUserName(dto.name) || userRepository.existByUserEmail(dto.email))
		{
		throw new RuntimeException("User already exist");
		
	    }
	
	User user = new User();
	
	user.setName(dto.getName());
	user.setEmail(dto.getEmail());
	user.setPassword(dto.getPassword());
	user.setRole(dto.getRole());
	
	userRepository.save(user);
	
	return "User registered successfully";
	
	}
	
	public String login(LoginRequestDTO dto)
	{
		User user = userRepository.finalByEmail(dto.getEmail()).orElseThrow(()-> new RuntimeException("User not found"));
		
		if(passwordEncoder.matches(dto.getPassword(), user.getPassword()))
		{
			throw new RuntimeException("Invalid Credentials");
		}
		
		return jwtUtil.generateToken(user);
	}
	
	
	
	

}
