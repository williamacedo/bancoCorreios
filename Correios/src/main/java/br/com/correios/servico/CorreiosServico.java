package br.com.correios.servico;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.correios.jpa.Transactional;
import br.com.correios.modelos.Bairro;
import br.com.correios.modelos.Cidade;
import br.com.correios.modelos.Endereco;
import br.com.correios.modelos.Estado;
import br.com.correios.repositorio.Correios;

public class CorreiosServico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Correios correios;
	private Cidade cidade;
	private Estado estado;
	private Bairro bairro;

	@Transactional
	public Bairro salvar(Bairro bairro) {

		bairro = new Bairro();
		bairro.getCidade();
		bairro.getEstado();
		Endereco endereco = new Endereco();
		bairro.setEndereco(endereco);
		// bairro.getEndereco();

		bairro = this.correios.guardar(bairro);
		return bairro;

	}

}
