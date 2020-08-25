package br.com.igordev.modelo;

import java.util.Calendar;

public class Imovel {
	private Long id;
	private String proprietario;
	private String endereco;
	private String tipo;
	private String contato;
	private Double valor;
	private Calendar dataInclusao;

	//construtor padrao
	public Imovel() {
	
	}//fim construtor
	
	

	public Imovel(String proprietario, String endereco, String tipo, String contato, Double valor,
			Calendar dataInclusao) {
		super();
		this.proprietario = proprietario;
		this.endereco = endereco;
		this.tipo = tipo;
		this.contato = contato;
		this.valor = valor;
		this.dataInclusao = dataInclusao;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Calendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	
	public boolean getContatoEhEmail() {
		return this.contato.contains("@");
	}
	

}
