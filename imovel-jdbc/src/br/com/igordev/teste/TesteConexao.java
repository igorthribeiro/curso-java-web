package br.com.igordev.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.igordev.dao.ConnectionFactory;

public class TesteConexao {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conctato ao Banco de dados!");
		connection.close();	
	}

}
