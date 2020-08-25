package br.com.igordev.despesas.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.igordev.despesas.modelo.Despesa;

@Repository
public class JpaDespesaDao implements DespesaDao {
	
	@PersistenceContext
	EntityManager manager;

	@Override
	public Despesa buscaPorId(Long id) {
		return manager.find(Despesa.class, id);
	}

	@Override
	public List<Despesa> lista() {
		return manager.createQuery("select d from despesa d", Despesa.class).getResultList();
	}

	@Override
	public void adiciona(Despesa despesa) {
		manager.persist(despesa);

	}

	@Override
	public void altera(Despesa despesa) {
		manager.merge(despesa);

	}

	@Override
	public void remove(Despesa despesa) {
		Despesa despesaRemover = buscaPorId(despesa.getId());
		manager.remove(despesaRemover);

	}

	@Override
	public void quita(Long id) {
		Despesa despesa = buscaPorId(id);
		despesa.setPago(true);
		despesa.setDataPagamento(Calendar.getInstance());
		manager.merge(despesa);
	}
}
