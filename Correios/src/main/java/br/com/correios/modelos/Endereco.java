package br.com.correios.modelos;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.correios.modelos.TipoLogadouro;


public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cep;
	private String logradouro;
	private TipoLogadouro tipo;
	

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	@ManyToOne
	@JoinColumn(name = "id_tipo")
	public TipoLogadouro getTipo() {
		return tipo;
	}

	public void setTipo(TipoLogadouro tipo) {
		this.tipo = tipo;
	}
	

}
