package com.poc.sr.dao.recruitement.request;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poc.sr.entities.ParamRefRemise;



public interface ParamRefRemiseRepository extends JpaRepository<ParamRefRemise, String>{
	
	@Query("SELECT paramRefRemise.idParamRefRemise from ParamRefRemise paramRefRemise")
	List<String>  findByIdParamRefRemise();

}
