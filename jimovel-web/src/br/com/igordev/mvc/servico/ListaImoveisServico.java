package br.com.igordev.mvc.servico;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.igordev.dao.ImovelDao;
import br.com.igordev.modelo.Imovel;

public class ListaImoveisServico implements Servico {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection connection = (Connection) request.getAttribute("conexao");
		
		List<Imovel> imoveis = new ImovelDao(connection).getLista();
		request.setAttribute("imoveis", imoveis);	
		return "/WEB-INF/jsp/lista-imoveis.jsp";	}

}
