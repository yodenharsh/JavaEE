package com.harsh.actalyst_webapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.harsh.actalyst_webapp.API.RequestOps;
import com.harsh.actalyst_webapp.entities.UserDetails;

@Controller
public class OnLoad {
	
	/**
	 * The first method that gets executed when visiting the domain
	 * @param aModel container for modal attributes
	 * @return String which has a controller or jsp mapped to it
	 */
	@RequestMapping("/")
	public String init(Model aModel) {
		int requestCount = RequestOps.getRequestCount();
		aModel.addAttribute("userDetails", new UserDetails());
		aModel.addAttribute("invalidInput", false); //Useful for when we need to redirect to same page
													//After invalid input was entered
		aModel.addAttribute("requestCount", requestCount);
		return "age-calculator";
	}
};
