package com.parroquia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {


//
	@RequestMapping("/verLogin")
	public String verLogin() { 
		
		return "login";
		
	}
	
	
	@RequestMapping("/verIntranetHome")
	public String verHome() { return "intranetHome"; }

	
	
}
