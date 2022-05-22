package com.poc.sr.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data 
public class AppUser {
	private String login;
	private String password;
	private String role;
}
