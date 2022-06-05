package com.poc.sr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "T_TYPE_REMISE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TypeRemise {
	
	
	private String nameTypeRemise;
	
	
	@Id
	@Column(length = 24, name ="s_id_type_remise")
	private String idTypeRemise;
	
	@Column(length = 2, name ="s_code")
	private String code;
	
	@Column(length = 24, name ="s_type")
	private String type;
	
	@Column(length = 64, name ="s_type_long")
	private String typeLong;
	
	


}
