package com.poc.sr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "r_param_type_valeur")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParamTypeValeur {
	
	@Id
	@Column(length = 256, name ="s_idParam_type_valeur")
	private String idParamTypeValeur;
	
	
	@Column(length = 246, name ="s_id_user")
	private String idUser;
	
	@Column(length = 246, name ="s_id_type_valeur")
	private String idTypeValeur;

}
