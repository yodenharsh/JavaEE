package com.harsh.actalyst_webapp.Controllers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.harsh.actalyst_webapp.API.RequestOps;
import com.harsh.actalyst_webapp.entities.UserDetails;

import jakarta.validation.Valid;

@Controller
public class FormController {

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("userDetails") UserDetails userDetails,
			BindingResult theBindingResult, Model model) {

		if (theBindingResult.hasErrors()) { // Triggered if any of the annotation conditions in UserDetails are not
											// satisfied
			model.addAttribute("invalidDetails", false);
			return "age-calculator";
		} else {
			LocalDate dob = Instant.ofEpochMilli((userDetails.getDob()).getTime()).atZone(ZoneId.systemDefault())
					.toLocalDate();
			// Conversion from Date to LocalDate and then passed to calcAge()
			String age = RequestOps.calcAge(dob);
			RequestOps.addRequests(dob);
			model.addAttribute("age", age);
			return "show-age";
		}
	}
}
