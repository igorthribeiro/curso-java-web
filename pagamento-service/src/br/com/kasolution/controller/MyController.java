package br.com.kasolution.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.kasolution.dados.StaticBD;
import br.com.kasolution.dominio.Pagamento;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public String index() {
		return "index";	
	}
	
	@RequestMapping("/ka")
	public String bemVindo() {
		return "ka-solution";	
	}
	
	@RequestMapping("/lista")
	public String get(Model model) {
		model.addAttribute("pagamentos", StaticBD.getPagamentos());
		return "lista-pagamentos";		
	}

}
