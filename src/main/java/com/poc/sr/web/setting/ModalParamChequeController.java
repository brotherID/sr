package com.poc.sr.web.setting;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poc.sr.dao.recruitement.request.TypeRemiseRepository;
import com.poc.sr.dao.recruitement.request.TypeValeurRepository;
import com.poc.sr.dao.recruitement.request.UserRepository;
import com.poc.sr.entities.TypeRemise;
import com.poc.sr.entities.TypeValeur;
import com.poc.sr.entities.User;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("modals")
@Slf4j
public class ModalParamChequeController {

	@Autowired
	public TypeRemiseRepository typeRemiseRepository;

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public TypeValeurRepository typeValeurRepository;

	@GetMapping("modal/cheque")
	public String getListIdtyperemise(@RequestParam("userId") String userId, Model model) {

		log.info("getListIdtyperemise .....");
		log.info("userId {}", userId);
		
		String idTypeValeur = typeValeurRepository.findByTypeValeur("CHQ");
    	model.addAttribute("idTypeValeur", idTypeValeur);
    	log.info("idTypeValeur {}",idTypeValeur);

		// select table TypeRemise
		List<TypeRemise> TypeRemisesCHQ = typeRemiseRepository.findAllByType("LCN");
		List<TypeRemise> TypeRemisesLCN = typeRemiseRepository.findAllByType("CHQ");
		model.addAttribute("typeRemisesCHQ", TypeRemisesCHQ);
		model.addAttribute("typeRemisesLCN", TypeRemisesLCN);

		// TODO select from table

		model.addAttribute("hasCheque", isHasCheque(userId));

		// list checked ? if have this type remise

		// TODO select from table
		model.addAttribute("listIdTypeRemiseHasUser", listIdTypeRemiseHasUser(userId));

		model.addAttribute("testUserId", userId);

		log.info("getListIdtyperemise done");
		return "params/parametre-cheque";
	}

	public boolean isHasCheque(String userId) {

		Optional<User> optionalUser = userRepository.findById(userId);
		User user = optionalUser.get();
		String idTypeValeurCheque = typeValeurRepository.findByTypeValeur("CHQ");
		Optional<TypeValeur> typeValeurCheque = user.getTypeValeurs().stream()
				.filter(typeValeur -> idTypeValeurCheque.equals(typeValeur.getIdTypeValeur())).findFirst();

		return typeValeurCheque.isPresent();

	}

	public List<String> listIdTypeRemiseHasUser(String userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		User user = optionalUser.get();
		return user.getTypeRemises().stream().map(TypeRemise::getIdTypeRemise).collect(Collectors.toList());

	}

}
