package com.harsh.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FormController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "hello-world-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("name");
		
		name = name.toUpperCase();
		
		model.addAttribute("name", name);
		
		
		return "hello-world";
	}
}
