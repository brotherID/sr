package com.poc.sr.service.recruitement.request;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.poc.sr.entities.AppUser;

@Service
public class AuthenticationServiceMockImpl implements AuthenticationService {

	private List<AppUser> users;

	public AuthenticationServiceMockImpl() {
		users = new ArrayList<AppUser>();
		users.add(new AppUser("user", "password", "USER"));
		users.add(new AppUser("admin", "password", "ADMIN"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) {

		Optional<AppUser> userOptional = users.stream().filter(user -> user.getLogin().equals(username)).findFirst();

		if (userOptional.isPresent()) {
			AppUser appUser = userOptional.get();
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(appUser.getRole()));

			return new User(appUser.getLogin(), "{noop}"+appUser.getPassword(), authorities);

		}
		

		return null;
	}

}
