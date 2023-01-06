package com.harsh.actalyst_webapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.harsh.actalyst_webapp.API.RequestOps;
import com.harsh.actalyst_webapp.entities.UserDetails;

@Controller
public class OnLoad {
	
	@RequestMapping("/")
	public String init(Model aModel) {
		boolean crossed500 = RequestOps.is500OrMore();
		aModel.addAttribute("crossed500", crossed500);
		aModel.addAttribute("userDetails", new UserDetails());
		aModel.addAttribute("invalidInput", false); //Useful for when we need to redirect to same page
													//After invalid input was entered
		return "age-calculator";
	}
};
