package br.com.igordev.despesas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {
	@RequestMapping("/olaMundoSpring")
	public String execute() {
		System.out.println("Executando um seviço com o Spring MVC");
		return "ok";
	}
}
