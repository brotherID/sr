package com.poc.sr.web.setting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.poc.sr.dao.recruitement.request.TypeRemiseRepository;
import com.poc.sr.dao.recruitement.request.TypeValeurRepository;
import com.poc.sr.entities.TypeRemise;
import com.poc.sr.entities.User;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class GetTypeRemiseController {
	
	@Autowired
	public TypeRemiseRepository typeRemiseRepository;
	
	@Autowired
	public TypeValeurRepository typeValeurRepository;
	
    @GetMapping("/getTypeRemise")
    public String getTypeRemise(Model model) {
    	log.info("****************start GetTypeRemiseController**********************");
    	//select table TypeValeur
    	String idTypeValeur = typeValeurRepository.findByTypeValeur("CHQ");
    	model.addAttribute("idTypeValeur", idTypeValeur);
    	log.info("idTypeValeur {}",idTypeValeur);
    	
    	
    	//select table User
        List<User> users= new ArrayList<User>();
		
		users.add(new User("user-id-1", "user 1", "password1") );
		
		users.add(new User("user-id-2", "user 2", "password2") );
		
		model.addAttribute("users", users);
    	
    	
		
    	
 
    	
    	// select table TypeRemise
		List<TypeRemise> TypeRemisesCHQ = typeRemiseRepository.findAllByType("LCN");
		List<TypeRemise> TypeRemisesLCN = typeRemiseRepository.findAllByType("CHQ");
		model.addAttribute("typeRemisesCHQ", TypeRemisesCHQ);
		model.addAttribute("typeRemisesLCN", TypeRemisesLCN);
		
		/* model.addAttribute("hasCheque", true); */
		
		// list checked ? if have this type remise 
		
		/*
		 * model.addAttribute("listIdTypeRemiseHasUser",
		 * Arrays.asList("011742123132","012231212312"));
		 */
		
		log.info("****************end GetTypeRemiseController****************");
    	
        return "params/users-params";
    }

}
