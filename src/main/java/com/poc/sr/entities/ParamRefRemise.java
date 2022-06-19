package com.poc.sr.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_PARAM_REF_REMISE")
@Data @NoArgsConstructor @AllArgsConstructor
public class ParamRefRemise {

	@Id
	@Column(length = 24, name ="s_id_param_ref_remise")
	private String idParamRefRemise;
	
	@Column(name = "n_is_auto")
	private Boolean isAuto;
	
	@Column(name = "n_is_numerique")
	private Boolean isNumerique;
	
	
	
}
