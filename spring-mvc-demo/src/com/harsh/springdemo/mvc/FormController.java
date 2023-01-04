package com.harsh.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class FormController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "hello-world-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@RequestParam("name") String name, Model model) {
				
		name = name.toUpperCase();
		
		model.addAttribute("name", name);
		
		
		return "hello-world";
	}
	
//	@RequestMapping("/processForm")
//	public String processForm(HttpServletRequest request, Model model) {
//		
//		String name = request.getParameter("name");
//		
//		name = name.toUpperCase();
//		
//		model.addAttribute("name", name);
//		
//		
//		return "hello-world";
//	}
	
}
