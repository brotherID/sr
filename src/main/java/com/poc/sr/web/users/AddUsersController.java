package com.poc.sr.web.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddUsersController {
	
	@GetMapping("/add-user")
	public String addUser() {
		
		return "users/add-user.html";
	}

}
