package com.poc.sr;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import com.poc.sr.service.recruitement.request.AuthenticationServiceMockImpl;

public class AuthenticationServiceMockImplTest {
	
	
	@Test
	public void   TestloadUserByUsername() {
		
		AuthenticationServiceMockImpl authenticationServiceMockImpl = new AuthenticationServiceMockImpl();
		
		
		UserDetails  userDetails = authenticationServiceMockImpl.loadUserByUsername("user");
		
		assertEquals("user", userDetails.getUsername() );
		assertEquals("password", userDetails.getPassword() );
		//Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		
		//assertEquals("USER", userDetails.getAuthorities() );
		
		
		
	}

}
