package com.poc.sr.web.setting;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.poc.sr.dao.recruitement.request.ParamRefRemiseRepository;

import com.poc.sr.dao.recruitement.request.TypeRemiseRepository;
import com.poc.sr.dao.recruitement.request.TypeValeurRepository;
import com.poc.sr.dao.recruitement.request.UserRepository;
import com.poc.sr.entities.TypeRemise;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class GetTypeRemiseController {
	
	@Autowired
	public TypeRemiseRepository typeRemiseRepository;
	
	@Autowired
	public TypeValeurRepository typeValeurRepository;
	
	@Autowired
	public ParamRefRemiseRepository paramRefRemiseRepository;

	
	@Autowired
	public UserRepository userRepository;
	
    @GetMapping("/getTypeRemise")
    public String getTypeRemise(Model model) {
    	log.info("****************start GetTypeRemiseController**********************");
    	//select table TypeValeur
    	String idTypeValeur = typeValeurRepository.findByTypeValeur("CHQ");
    	model.addAttribute("idTypeValeur", idTypeValeur);
    	log.info("idTypeValeur {}",idTypeValeur);
    	
    	
    	//select table User
    	model.addAttribute("users", userRepository.findAll());
    	// select table TypeRemise
		List<TypeRemise> TypeRemisesCHQ = typeRemiseRepository.findAllByType("LCN");
		List<TypeRemise> TypeRemisesLCN = typeRemiseRepository.findAllByType("CHQ");
		model.addAttribute("typeRemisesCHQ", TypeRemisesCHQ);
		model.addAttribute("typeRemisesLCN", TypeRemisesLCN);
		
		model.addAttribute("hasCheque", true); 
		
		// list checked ? if have this type remise 
		model.addAttribute("listIdTypeRemiseHasUser",
		Arrays.asList("011742123132","012231212312"));
		//
		List<String> idParamRefRemise = paramRefRemiseRepository.findByIdParamRefRemise();
		model.addAttribute("idParamRefRemise", idParamRefRemise);
		
		
		log.info("****************end GetTypeRemiseController****************");
    	
        return "params/users-params";
    }

}
