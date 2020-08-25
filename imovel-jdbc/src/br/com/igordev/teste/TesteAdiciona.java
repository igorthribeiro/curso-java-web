package br.com.igordev.teste;

import java.util.Calendar;

import br.com.igordev.dao.ImovelDao;
import br.com.igordev.modelo.Imovel;

public class TesteAdiciona {

	public static void main(String[] args) {
		Imovel imovel = new Imovel();
		imovel.setProprietario("Igor Ribeiro");
		imovel.setEndereco("Vila Mariana");
		imovel.setTipo("aluguel");
		imovel.setContato("igorth.genesis@gmail.com");
		imovel.setValor(1000.00);
		imovel.setDataInclusao(Calendar.getInstance());
		new ImovelDao().adiciona(imovel);
		System.out.println("Salvo no BD.");
	}//fim main

}
