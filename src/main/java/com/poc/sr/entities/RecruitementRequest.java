package com.poc.sr.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;


import com.poc.sr.enumeration.ContractLength;
import com.poc.sr.enumeration.NumberYearsExperience;
import com.poc.sr.enumeration.Sector;
import com.poc.sr.enumeration.Skills;
import com.poc.sr.enumeration.TypeContract;
import com.poc.sr.enumeration.TypeRecruitment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class RecruitementRequest {
	
	@Id
	private String id;
	
	private String intitulePoste;
	
	@Enumerated(EnumType.STRING)
	private TypeRecruitment typeRecruitment;
	
	@Enumerated(EnumType.STRING)
	private NumberYearsExperience numberYearsExperience;
	
	@Enumerated(EnumType.STRING)
	private Sector  sector;
	
	@Enumerated(EnumType.STRING)
	private Skills skills;
	
	private Date startingDate;
	
	private float costCharged;
	
	private String geographicSite;
	
	private String  namePerson;
	
	@Enumerated(EnumType.STRING)
	private TypeContract typeContract;
	
	@Enumerated(EnumType.STRING)
	private ContractLength contractLength;
	
	private float plannedNetSalary;
	
	private float chargedCost;

}
