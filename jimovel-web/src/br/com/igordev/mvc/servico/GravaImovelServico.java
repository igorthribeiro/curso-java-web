package br.com.igordev.mvc.servico;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.igordev.dao.ImovelDao;
import br.com.igordev.modelo.Imovel;

public class GravaImovelServico implements Servico {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sId = request.getParameter("id");
		String proprietario = request.getParameter("proprietario");
		String endereco = request.getParameter("endereco");
		String tipo = request.getParameter("tipo");
		String contato = request.getParameter("contato");
		Calendar dataInclusao = null;
		Double valor = null;
		try {
			valor = new Double(request.getParameter("valor"));
			Date date = new SimpleDateFormat("dd/MM/yyyy")
					.parse(request.getParameter("dataInclusao"));
			dataInclusao = Calendar.getInstance();
			dataInclusao.setTime(date);
		} catch (RuntimeException e) {
			throw new ServletException(e);
		} catch (ParseException e) {
			throw new ServletException(e);
		}		
		
		//Instanciação do Imovel
		Imovel imovel = new Imovel(proprietario, endereco, tipo, contato, valor,
				dataInclusao);		
		//Gravar no BD com o DAO
		
		Connection connection = (Connection) request.getAttribute("conexao");
		
		if (sId == null || sId.equals("")) {
			new ImovelDao(connection).adiciona(imovel);
		} else {
			Long id = Long.parseLong(sId);
			imovel.setId(id);
			new ImovelDao().altera(imovel);
		}		
		//retorna a para o serviço de listar
		return new ListaImoveisServico().executa(request, response);//return "mvc?servico=ListaImoveisServico" 
	}

}
