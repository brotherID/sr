package com.poc.sr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "r_param_type_remise")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParamTypeRemise {
	
	@Id
	@Column(length = 256, name ="s_idParam_type_remise")
	private String idParamTypeRemise;
	
	
	@Column(length = 246, name ="s_id_user")
	private String idUser;
	
	@Column(length = 246, name ="s_id_type_remise")
	private String idTypeRemise;
	
	

}
