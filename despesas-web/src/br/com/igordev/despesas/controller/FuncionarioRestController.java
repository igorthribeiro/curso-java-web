package br.com.igordev.despesas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.igordev.despesas.dao.JpaFuncionarioDao;
import br.com.igordev.despesas.modelo.Funcionario;

@CrossOrigin(origins = "*", allowedHeaders = "*") // habilitado no controller
@Transactional
@RestController
public class FuncionarioRestController {

	@Autowired
	@Qualifier("jpaFuncionarioDao")
	private JpaFuncionarioDao dao;

	@RequestMapping("/")
	public String index() {
		return "Servidor iniciado!";
	}

	// @CrossOrigin(origins = "http://localhost:9000") //habilitado no método
	@RequestMapping(value = "grava", method = RequestMethod.POST)
	@ResponseBody
	public void salva(@RequestBody Funcionario funcionario) {
		if (funcionario.getCodigo() == 0) {
			dao.salvar(funcionario);
		} else {
			dao.atualizar(funcionario);
		}
	}

	@RequestMapping(value = "lista", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Funcionario> getFuncionarios() {
		return dao.buscarTodos();
	}

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Funcionario getFuncionario(@PathVariable("id") int id) {
		return dao.buscarId(id);
	}

	@RequestMapping(value = "remove/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void remove(@PathVariable("id") int id) {
		Funcionario f = dao.buscarId(id);
		dao.excluir(f);
	}

}
