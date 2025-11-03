package com.set_job_portal.Security;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.set_job_portal.Entity.User;
import com.set_job_portal.Enum.Role;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil
{
	
	private final String jwtSecret = "zidio_secret";
	private final long jwtExpiration = 86400000;
	
	public String generateToken(User user) 
	{
		return Jwts.builder().
				setSubject(user.getEmail()).
				claim("role",user.getRole()).
				setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis()+jwtExpiration)).
				signWith(SignatureAlgorithm.HS512,jwtSecret).
				compact();
	}
	
	public String getUserNameFromToken(String token)
	{
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
		
	}
	
	public boolean validateToken(String token)
	{
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	
	
	

}
