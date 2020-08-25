package br.com.igordev.despesas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.igordev.despesas.modelo.Despesa;

@Repository
public class JdbcDespesaDao implements DespesaDao {
	
	private final Connection connection;

	@Autowired
	public JdbcDespesaDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void adiciona(Despesa despesa) {
		String sql = "insert into despesa (descricao, pago) values (?, ?)";
		PreparedStatement stmt;
		try {
			 stmt = connection.prepareStatement(sql);
			 stmt.setString(1, despesa.getDescricao());
			 stmt.setBoolean(2, despesa.isPago());
			 stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Despesa despesa) {
		if (despesa.getId() == null) {
			throw new IllegalStateException("Id da despesa não deve ser nulo.");
		}
		String sql = "delete from despesa where id = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, despesa.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Despesa despesa) {
		String sql = "update despesa set descricao = ?, pago = ?, dataPagamento = ? where id = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, despesa.getDescricao());
			stmt.setBoolean(2, despesa.isPago());
			stmt.setDate(3, despesa.getDataPagamento() != null ? new Date(
					despesa.getDataPagamento().getTimeInMillis()) : null);
			stmt.setLong(4, despesa.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Despesa ormDespesa(ResultSet rs) throws SQLException {
		Despesa despesa = new Despesa();
		
		despesa.setId(rs.getLong("id"));
		despesa.setDescricao(rs.getString("descricao"));
		despesa.setPago(rs.getBoolean("pago"));
		Date data = rs.getDate("dataPagamento");
		if (data != null) {
			Calendar dataPagamento = Calendar.getInstance();
			dataPagamento.setTime(data);
			despesa.setDataPagamento(dataPagamento);
		}
		return despesa;
	}
	
	public Despesa buscaPorId(Long id) {
		if (id == null) {
			throw new IllegalStateException("Id da despesa não pode ser nulo.");
		}
		try {
			PreparedStatement stmt = connection.prepareStatement("select * from despesa where id = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return ormDespesa(rs);
			}
			rs.close();
			stmt.close();
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Despesa> lista() {
		try {
			List<Despesa> despesas = new ArrayList<>();
			PreparedStatement stmt = connection.prepareStatement("select * from despesa");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				despesas.add(ormDespesa(rs));
			}
			rs.close();
			stmt.close();
			return despesas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}	
	
	public void quita(Long id) {
		String sql = "update despesa set pago = ?, dataPagamento = ? where id = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setBoolean(1, true);
			stmt.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
			stmt.setLong(3, id);
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
