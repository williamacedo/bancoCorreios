package br.com.correios.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.correios.busca.CorreioBusca;
import br.com.correios.modelos.Bairro;
import br.com.correios.repositorio.Correios;

@Named
@ViewScoped
public class PesquisaCorreiosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private Correios correios;

	private CorreioBusca filtro;

	private List<Bairro> buscaRealizada;

	public PesquisaCorreiosBean() {
		filtro = new CorreioBusca();
		buscaRealizada = new ArrayList<>();

	}

	public void pesquisar() {
		buscaRealizada = correios.filtrados(filtro);

	}

	public Correios getCorreios() {
		return correios;
	}

	public void setCorreios(Correios correios) {
		this.correios = correios;
	}

	public CorreioBusca getFiltro() {
		return filtro;
	}

	public void setFiltro(CorreioBusca filtro) {
		this.filtro = filtro;
	}

	public List<Bairro> getBuscaRealizada() {
		return buscaRealizada;
	}

	public void setBuscaRealizada(List<Bairro> buscaRealizada) {
		this.buscaRealizada = buscaRealizada;
	}

}