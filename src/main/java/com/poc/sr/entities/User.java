package com.poc.sr.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "T_USER")
@AllArgsConstructor
@NoArgsConstructor
@Data 
public class User {
	
	 @Id
	 @Column(length = 24, name ="s_id_user")
	 private String idUser;
	 private String login;
	 private String password;
	 
	 @ManyToMany
	 @JoinTable(
			  name = "R_PARAM_TYPE_VALEUR", 
			  joinColumns = @JoinColumn(name = "s_id_user"), 
			  inverseJoinColumns = @JoinColumn(name = "s_id_type_valeur"))
	 private Collection<TypeValeur> typeValeurs;
	 
	 
	 @ManyToMany
	 @JoinTable(
			  name = "R_PARAM_TYPE_REMISE", 
			  joinColumns = @JoinColumn(name = "s_id_user"), 
			  inverseJoinColumns = @JoinColumn(name = "s_id_type_remise"))
	 private Collection<TypeRemise> typeRemises;
	 
	 

}
