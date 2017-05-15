package br.com.correios.controle;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.correios.jsf.FacesUtil;
import br.com.correios.modelos.Bairro;
import br.com.correios.modelos.Cidade;
import br.com.correios.modelos.Endereco;
import br.com.correios.modelos.Estado;
import br.com.correios.servico.CorreiosServico;

@Named
@ViewScoped
public class CadastroCorreiosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Bairro bairro;
	private Cidade cidade;
	private Estado estado;

	@Inject
	private CorreiosServico correiosServico;

	public CadastroCorreiosBean() {
		limpar();
	}

	private void limpar() {
		estado = new Estado();
		cidade = new Cidade();
		Endereco endereco = new Endereco();
		bairro = new Bairro();
		bairro.setEndereco(endereco);

	}

	public void salvar() {

		this.bairro = correiosServico.salvar(this.bairro);
		limpar();
		FacesUtil.addInfoMessage("Salvo com sucesso!");
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public CorreiosServico getCorreiosServico() {
		return correiosServico;
	}

	public void setCorreiosServico(CorreiosServico correiosServico) {
		this.correiosServico = correiosServico;
	}

}