package com.poc.sr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_TYPE_VALEUR")
@Data @NoArgsConstructor @AllArgsConstructor
public class TypeValeur {
	
	@Id
	@Column(length = 24, name ="s_id_type_valeur")
	private String idTypeValeur;
	
	@Column(length = 3, name ="s_type")
	private String type;
	
	@Column(length = 10, name ="s_type_long")
	private String typeLong;

}
