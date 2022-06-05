package com.poc.sr.dao.recruitement.request;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poc.sr.entities.TypeValeur;

public interface TypeValeurRepository extends JpaRepository<TypeValeur, String>{
	
	@Query("SELECT typeValeur.idTypeValeur from TypeValeur typeValeur where typeValeur.type = :typeValeur")
	public String findByTypeValeur(@Param("typeValeur")String typeValeur);

}
