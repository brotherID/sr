package com.poc.sr.service.recruitement.request;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {
	
	public UserDetails loadUserByUsername(String username);

}
