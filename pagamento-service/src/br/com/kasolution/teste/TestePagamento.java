package br.com.kasolution.teste;

import java.time.LocalDate;
import java.util.List;

import br.com.kasolution.dados.StaticBD;
import br.com.kasolution.dominio.Pagamento;

public class TestePagamento {
	
	public static void main(String[] args) {
		List<Pagamento> pagamentos = StaticBD.getPagamentos();
		System.out.println("Lista de pagamentos: ");
		pagamentos.forEach(System.out::println);
		
		System.out.println("\nPagamento para hoje:");
		double totalHoje = StaticBD.getPagamentos()
								.stream().filter(p -> p.getDataVencimento().equals(LocalDate.now()))
								.mapToDouble(Pagamento::getValor).sum();
		System.out.println("Total para Hoje: " + totalHoje);
	}

}
