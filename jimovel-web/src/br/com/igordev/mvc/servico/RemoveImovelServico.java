package br.com.igordev.mvc.servico;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.igordev.dao.ImovelDao;
import br.com.igordev.modelo.Imovel;

public class RemoveImovelServico implements Servico {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection connection = (Connection) request.getAttribute("conexao");

		Long id = Long.parseLong(request.getParameter("id"));
		Imovel imovel = new Imovel();
		imovel.setId(id);
		System.out.println("Excluindo o imóvel...");
		new ImovelDao(connection).remove(imovel);
		return new ListaImoveisServico().executa(request, response);// return "mvc?servico=ListaImoveisServico"
	}
}
