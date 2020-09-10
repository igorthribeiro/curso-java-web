package br.com.kasolution.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kasolution.dados.StaticBD;
import br.com.kasolution.dominio.Pagamento;

@CrossOrigin(origins = "*", allowedHeaders = "*") // habilitado no controller
@RestController
public class RestfulController {

	@RequestMapping("get-pagamento/{id}")
	public Pagamento getPagamento(@PathVariable("id") int id) {
		Pagamento pagamento = StaticBD.getPagamentos().get(id);
		return pagamento;
	}

	@RequestMapping("get-pagamentos/{data}")
	public List<Pagamento> getPagamento(@PathVariable("data") String data) {
		switch (data) {
			case "hoje":
				return StaticBD.getPagamentos()
						.stream()
						.filter(p -> p.getDataVencimento().equals(LocalDate.now()))
						.collect(Collectors.toList());
			case "todos":
				return StaticBD.getPagamentos();
			default:
				return null;
			}
	}

}
