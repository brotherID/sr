package com.poc.sr.web.setting;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poc.sr.dao.recruitement.request.TypeRemiseRepository;
import com.poc.sr.entities.TypeRemise;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("modals")
@Slf4j
public class ModalParamChequeController {
	
	@Autowired
	public TypeRemiseRepository typeRemiseRepository;

	@GetMapping("modal/cheque")
	public String getListIdtyperemise(@RequestParam("userId") String userId, Model model) {

		log.info("getListIdtyperemise .....");
		log.info("userId {}" , userId);
		
		
		// select table TypeRemise
		List<TypeRemise> TypeRemisesCHQ = typeRemiseRepository.findAllByType("LCN");
		List<TypeRemise> TypeRemisesLCN = typeRemiseRepository.findAllByType("CHQ");
		model.addAttribute("typeRemisesCHQ", TypeRemisesCHQ);
		model.addAttribute("typeRemisesLCN", TypeRemisesLCN);
		
	   // TODO select from table
		model.addAttribute("hasCheque", true);
		
		// list checked ? if have this type remise 
		
		// TODO select from table
		model.addAttribute("listIdTypeRemiseHasUser", Arrays.asList("011742123132","012231212312"));

		

		model.addAttribute("testUserId", userId);

		log.info("getListIdtyperemise done");
		return "params/parametre-cheque";
	}

}
