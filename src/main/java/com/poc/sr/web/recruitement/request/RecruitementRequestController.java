package com.poc.sr.web.recruitement.request;


import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poc.sr.dto.RecruitementRequestDto;
import com.poc.sr.service.recruitement.request.RecruitementRequestService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@AllArgsConstructor
@Slf4j
public class RecruitementRequestController {
	
	
	private RecruitementRequestService recruitementRequestService;
	
	
	
	
	
	@GetMapping("/recruitement-request")
	@PreAuthorize("hasAuthority('ADMIN')")
    public String dislayForm() {
		
        return "request/recruitement-request";
    }
	
	
	@PostMapping("/recruitement-request")
	
	public String saveRecruitementRequest( HttpServletRequest req, Model model,@RequestParam("files") MultipartFile[] files) {
		
		RecruitementRequestDto recruitementRequestDto = new RecruitementRequestDto();
		
		
		String intitulePoste= req.getParameter("JobTitleInput");
		
		log.info("intitulé poste "+  intitulePoste);
		log.info("user.dir :"+System.getProperty("user.dir"));
		
		   
		
		recruitementRequestDto.setIntitulePoste(intitulePoste);
		recruitementRequestDto.setMailFiles(files);
		
		recruitementRequestService.addRecruitementRequest(recruitementRequestDto);
		
		return "recruitement-request";
	}
	
	@GetMapping("/test")
	
    public String test() {
		
        return "listUsers";
    }
}
