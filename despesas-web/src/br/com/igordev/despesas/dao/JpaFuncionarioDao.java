package br.com.igordev.despesas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.igordev.despesas.modelo.Funcionario;

@Repository
public class JpaFuncionarioDao {

	@PersistenceContext
	EntityManager manager;

	
	public void salvar(Funcionario funcionario) {
		manager.persist(funcionario);
	}// fim salvar

	public void atualizar(Funcionario funcionario) {
		manager.merge(funcionario);
	}// fim atualizar

	public void excluir(Funcionario funcionario) {
		manager.remove(funcionario);
	}// fim excluir

	public Funcionario buscarId(int id) {
		return manager.find(Funcionario.class, id);
	}// fim buscarId

	public List<Funcionario> buscarTodos() {
		return  manager.createQuery("select f from funcionario f", Funcionario.class).getResultList();
	}// fim buscarTodos

}
