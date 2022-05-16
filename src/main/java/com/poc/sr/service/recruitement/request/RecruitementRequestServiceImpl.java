package com.poc.sr.service.recruitement.request;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.poc.sr.dao.recruitement.request.RecruitementRequestRepository;
import com.poc.sr.dto.RecruitementRequestDto;
import com.poc.sr.entities.RecruitementRequest;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecruitementRequestServiceImpl implements RecruitementRequestService {

	private RecruitementRequestRepository recruitementRequestRepository;
	
	public void uploadMailFiles(MultipartFile[] files) 
	{
		String uploadDirectory = System.getProperty("user.dir")+"/uploads";
		new File(uploadDirectory).mkdir();
		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : files) {
			  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			  fileNames.append(file.getOriginalFilename()+" ");
			  try {
				Files.write(fileNameAndPath, file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		  }
		
	}
		   
		  
    
	
	

	@Override
	public RecruitementRequest addRecruitementRequest(RecruitementRequestDto recruitementRequestDto) {

		recruitementRequestDto.setId(UUID.randomUUID().toString());
		//uploadMailFiles(recruitementRequestDto.getMailFiles());
		RecruitementRequest recruitementRequest = new RecruitementRequest();
	
        //mapper
		BeanUtils.copyProperties(recruitementRequestDto, recruitementRequest);

		RecruitementRequest request = recruitementRequestRepository.save(recruitementRequest);

		return request;

	}

	
	 

}
