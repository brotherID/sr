package com.poc.sr.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data 
public class User {
	
	 private String idUser;
	 private String login;
	 private String password;

}
