package com.poc.sr.dao.recruitement.request;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poc.sr.entities.TypeRemise;


public interface TypeRemiseRepository extends JpaRepository<TypeRemise, String>{
	
	@Query("SELECT typeRemise from TypeRemise typeRemise WHERE typeRemise.type not like %:type")
	List<TypeRemise> findAllByType(@Param("type")String type);
	
	
	@Query("SELECT typeRemise.idTypeRemise from TypeRemise typeRemise")
	List<String>  findByIdTypeRemise();
	
	
}
