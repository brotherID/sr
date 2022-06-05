package com.poc.sr.web.setting;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.poc.sr.dao.recruitement.request.ParamTypeRemiseRepository;
import com.poc.sr.dao.recruitement.request.ParamTypeValeurRepository;
import com.poc.sr.dao.recruitement.request.TypeRemiseRepository;
import com.poc.sr.dao.recruitement.request.TypeValeurRepository;
import com.poc.sr.entities.ParamTypeRemise;
import com.poc.sr.entities.ParamTypeValeur;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AddTypeRemiseController {
	
	@Autowired
	public TypeRemiseRepository typeRemiseRepository;
	
	@Autowired
	public ParamTypeRemiseRepository paramTypeRemiseRepository;
	
	@Autowired
	public ParamTypeValeurRepository paramTypeValeurRepository;
	
	@Autowired
	public TypeValeurRepository typeValeurRepository;
	
	@Autowired
	public GetTypeRemiseController getTypeRemiseController;
	
	
	@PostMapping("/addTypeRemise")
	public String addTypeRemise(HttpServletRequest req, Model model)
	{
		log.info("****************start AddTypeRemiseController**********************");
		
		// get userId
		String userId = req.getParameter("userIDParametreCheque");
		log.info("user id :{} ",userId);
		
		//get idTypeValeur
		String idTypeValeur = typeValeurRepository.findByTypeValeur("CHQ");
		log.info("idTypeValeur :{} ",idTypeValeur);
		log.info("req.getParameter(idTypeValeur) :{} ",req.getParameter(idTypeValeur));
		//insert table ParamTypeValeur
		if("on".equals(req.getParameter(idTypeValeur)))
		{
			log.info("test");
			ParamTypeValeur paramTypeValeur = new ParamTypeValeur();
			paramTypeValeur.setIdParamTypeValeur(UUID.randomUUID().toString());
			paramTypeValeur.setIdTypeValeur(idTypeValeur);
			paramTypeValeur.setIdUser(userId);
			paramTypeValeurRepository.save(paramTypeValeur);
		}
		log.info("paramTypeValeur :{} ",paramTypeValeurRepository.findAll());
		
		// add listIdTypeRemisesOn
		
		List<String> listIdTypeRemises = typeRemiseRepository.findByIdTypeRemise();
		
		log.info("listIdTypeRemises :{}", listIdTypeRemises);
		
		List<String> listIdTypeRemisesOn = new ArrayList<String>(); 
		
		for(String  idTypeRemise : listIdTypeRemises  )
		{
			log.info("req.getParameter(idTypeRemise) : {}", req.getParameter(idTypeRemise));
			if("on".equals(req.getParameter(idTypeRemise)))
			{
				listIdTypeRemisesOn.add(idTypeRemise);
				
			}
			
		}
		log.info("listIdTypeRemisesOn :{}",listIdTypeRemisesOn);
		
		
		// insert table ParamTypeRemise
		for(String  idTypeRemisesOn : listIdTypeRemisesOn  )
		{
			ParamTypeRemise paramTypeRemise =new ParamTypeRemise();
			
			paramTypeRemise.setIdParamTypeRemise(UUID.randomUUID().toString());
			paramTypeRemise.setIdUser(userId);
			paramTypeRemise.setIdTypeRemise(idTypeRemisesOn);
			paramTypeRemiseRepository.save(paramTypeRemise);
		}
		
		log.info("findall paramTypeValeur : {}",paramTypeRemiseRepository.findAll());
		getTypeRemiseController.getTypeRemise(model);
		log.info("****************end AddTypeRemiseController**********************");
		
		return "params/users-params";
	}

}
