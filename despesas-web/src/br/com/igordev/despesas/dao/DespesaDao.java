package br.com.igordev.despesas.dao;

import java.util.List;

import br.com.igordev.despesas.modelo.Despesa;

public interface DespesaDao {

	Despesa buscaPorId(Long id);
	List<Despesa> lista();
	void adiciona(Despesa despesa);
	void altera(Despesa despesa);
	void remove(Despesa despesa);
	void quita(Long id);	
	
}
