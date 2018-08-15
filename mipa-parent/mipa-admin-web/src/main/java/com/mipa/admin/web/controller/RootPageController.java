package com.mipa.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RootPageController {

	@RequestMapping(path="/index", method=RequestMethod.GET)
	public String indexPage() {
		return "redirect.homepage";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String loginPage() {
		return "loginpage";
	}

	@RequestMapping(path="/admin/home")
	public String adminHomePage() {
		return "homepage";
	}
	
	@RequestMapping(path="/accessdenied")
	public String accessDeniedPage() {
		return "accessdenied";
	}	
}