package com.project.jun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	
	@GetMapping(value="/loginsuccess")
	public String success() {
		System.out.println("굿");
		return "redirect:http://www.naver.com";
	}
}

