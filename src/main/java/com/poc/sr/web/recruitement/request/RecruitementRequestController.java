package com.poc.sr.web.recruitement.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecruitementRequestController {
	
	@GetMapping("/recruitement-request")
    public String recruitementRequest() {
        return "/recruitement-request";
    }

}
