package com.poc.sr.web.params;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poc.sr.entities.TypeRemise;

@Controller
public class UpdateTypeRemiseController {

	@PostMapping(value = "/updateTypeRemise")
	public ModelAndView updateTypeRemise(HttpServletRequest req, Model mode) {
		
		List<String> listIdTypeRemises = new ArrayList<String>();
		
		for(TypeRemise typeRemise : findAll()) {
		
			//si on a coché sur la case
			if("on".equals(req.getParameter("choixTypeRemise-"+typeRemise.getIdTypeRemise()))) {
				listIdTypeRemises.add(typeRemise.getIdTypeRemise());	
			}
		   
			
		}
		
		System.out.println("listIdTypeRemises "+listIdTypeRemises);

		String qsdfqsd = req.getParameter("choixTypeRemise-TypeRemise1");
		System.out.println("qsdfqsd : " + qsdfqsd);

		String userIDParametreCheque = req.getParameter("userIDParametreCheque");
		System.out.println("userIDParametreCheque : " + userIDParametreCheque);

		return new ModelAndView("params/users-params");
	}

	private List<TypeRemise> findAll() {

		List<TypeRemise> params = new ArrayList<TypeRemise>();

		/*
		 * params.add(new TypeRemise("TypeRemise1", "encaissement")); params.add(new
		 * TypeRemise("TypeRemise2", "non endossable")); params.add(new
		 * TypeRemise("TypeRemise3", "endossable"));
		 */

		return params;

	}

}
