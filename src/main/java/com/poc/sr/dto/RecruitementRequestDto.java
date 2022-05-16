package com.poc.sr.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RecruitementRequestDto {

	private String id;

	private String intitulePoste;
	
	private MultipartFile[] mailFiles;

}
