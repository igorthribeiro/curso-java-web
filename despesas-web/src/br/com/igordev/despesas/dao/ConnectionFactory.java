package br.com.igordev.despesas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost/imovel";
		String usuario = "root";
		String senha = "";
		try {
			Class.forName("com.mysql.jdbc.Driver"); //necessário para o Tomcat 7
			return DriverManager.getConnection(url, usuario, senha);
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException(ex);
		}
	}
}
