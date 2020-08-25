package br.com.igordev.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.igordev.dao.ImovelDao;
import br.com.igordev.modelo.Imovel;

@WebServlet("/cadastraImovel")
public class CadastraImovelServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Leitura dos parâmetros do HTML
		PrintWriter out = response.getWriter();
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
//			out.println("Erro de conversão de valor! (Não numérico)");
//			return;
		} catch (ParseException e) {
			throw new ServletException(e);
//			out.println("Erro de conversão de data! use (DD/MM/YYYY)");
//			return;
		}
		
		//Instanciação do Imovel
		Imovel imovel = new Imovel(proprietario, endereco, tipo, contato, valor,
				dataInclusao);
		
		//Gravar no BD com o DAO
		new ImovelDao().adiciona(imovel);
		
		//Resposta para o cliente
		out.println("<html><body><h3>");
		out.println("Imovel " + imovel.getEndereco() + " cadastrado com sucesso!");
		out.println("</h3></body></html>");	
	}
	
}
