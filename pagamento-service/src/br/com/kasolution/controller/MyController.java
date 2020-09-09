package br.com.kasolution.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public String ola() {
		return "index";	
	}
	
	@RequestMapping("/ka")
	public String bemVindo() {
		return "ka-solution";	
	}

}
