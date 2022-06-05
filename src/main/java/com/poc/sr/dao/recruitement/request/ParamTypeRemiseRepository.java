package com.poc.sr.dao.recruitement.request;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poc.sr.entities.ParamTypeRemise;



public interface ParamTypeRemiseRepository extends JpaRepository<ParamTypeRemise, String> {
	
	//DELETE FROM public.r_param_type_remise WHERE s_id_type_remise ='011742123132' and s_id_user= 'sdf';
	
	/*
	 * @Query("DELETE FROM   ParamTypeRemise paramTypeRemise WHERE  paramTypeRemise. s_id_type_remise = :userID"
	 * ) void deleteByUserID(String userID);
	 */
	

}
