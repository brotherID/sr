package com.poc.sr.web.setting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.poc.sr.dao.recruitement.request.ParamTypeValeurRepository;
import com.poc.sr.dao.recruitement.request.TypeRemiseRepository;
import com.poc.sr.dao.recruitement.request.TypeValeurRepository;
import com.poc.sr.dao.recruitement.request.UserRepository;
import com.poc.sr.entities.TypeRemise;
import com.poc.sr.entities.TypeValeur;
import com.poc.sr.entities.User;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AddTypeRemiseController {

	@Autowired
	public TypeRemiseRepository typeRemiseRepository;

	@Autowired
	public ParamTypeValeurRepository paramTypeValeurRepository;

	@Autowired
	public TypeValeurRepository typeValeurRepository;

	@Autowired
	public GetTypeRemiseController getTypeRemiseController;

	@Autowired
	public UserRepository userRepository;

	@PostMapping("/addTypeRemise")
	public String addTypeRemise(HttpServletRequest req, Model model) {
		log.info("****************start AddTypeRemiseController**********************");

		// get userId
		String userId = req.getParameter("userIDParametreCheque2");
		log.info("user id :{} ", userId);

		// get idTypeValeur
		String idTypeValeur = typeValeurRepository.findByTypeValeur("CHQ");
		log.info("idTypeValeur :{} ", idTypeValeur);
		log.info("req.getParameter(idTypeValeur) :{} ", req.getParameter(idTypeValeur));
		// insert table ParamTypeValeur
		if ("on".equals(req.getParameter(idTypeValeur))) {
			log.info("test");
			Optional<User> optionalUser = userRepository.findById(userId);
			User user = optionalUser.get();
			Optional<TypeValeur> optionalTypeValeur = typeValeurRepository.findById(idTypeValeur);
		
			TypeValeur typeValeur = optionalTypeValeur.get();
			Set<TypeValeur> setTypeValeurs = new HashSet(user.getTypeValeurs());
			setTypeValeurs.add(typeValeur);
			user.setTypeValeurs(setTypeValeurs);
			userRepository.save(user);
	
		}

		List<String> listIdTypeRemises = typeRemiseRepository.findByIdTypeRemise();

		log.info("listIdTypeRemises :{}", listIdTypeRemises);

		List<String> listIdTypeRemisesOn = new ArrayList<String>();

		for (String idTypeRemise : listIdTypeRemises) {
			log.info("req.getParameter(idTypeRemise) : {}", req.getParameter(idTypeRemise));
			if ("on".equals(req.getParameter(idTypeRemise))) {
				listIdTypeRemisesOn.add(idTypeRemise);

			}

		}
		log.info("listIdTypeRemisesOn :{}", listIdTypeRemisesOn);
		
		Optional<User> optionalUser = userRepository.findById(userId);
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.setTypeRemises(buildNewListTypeRemises(req));
			userRepository.save(user);
		}
		
		getTypeRemiseController.getTypeRemise(model);
		log.info("****************end AddTypeRemiseController**********************");

		return "params/users-params";
	}

	List<TypeRemise> buildNewListTypeRemises(HttpServletRequest req) {

		List<TypeRemise> typeRemisesUpdated = new ArrayList<TypeRemise>();
		List<String> listIdTypeRemises = typeRemiseRepository.findByIdTypeRemise();
		for (String idTypeRemise : listIdTypeRemises) {
			log.info("req.getParameter(idTypeRemise) : {}", req.getParameter(idTypeRemise));
			
			if (isTypeRemiseSelected(req,idTypeRemise)) {
				Optional<TypeRemise> optionalTypeRemise = typeRemiseRepository.findById(idTypeRemise);
				if (optionalTypeRemise.isPresent()) {
					typeRemisesUpdated.add(optionalTypeRemise.get());
				}
			}
		}
		return typeRemisesUpdated;
	}

	private boolean isTypeRemiseSelected(HttpServletRequest req, String idTypeRemise) {
		return "on".equals(req.getParameter(idTypeRemise));
	}

}
