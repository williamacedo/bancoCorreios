package br.com.correios.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.correios.busca.CorreioBusca;
import br.com.correios.modelos.Bairro;

public class Correios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Bairro guardar(Bairro bairro) {

		return manager.merge(bairro);

	}

	@SuppressWarnings("unchecked")
	public List<Bairro> filtrados(CorreioBusca filtro) {
		Session session = this.manager.unwrap(Session.class);

		Criteria criteria = session.createCriteria(Bairro.class).createAlias("estado", "est").createAlias("cidade",
				"cid");

		if (StringUtils.isNotBlank(filtro.getNomeBairro())) {

			criteria.add(Restrictions.ilike("nome", filtro.getNomeBairro(), MatchMode.ANYWHERE));
		}

		if (StringUtils.isNotBlank(filtro.getNomeCidade())) {

			criteria.add(Restrictions.ilike("cid.nome", filtro.getNomeCidade(), MatchMode.ANYWHERE));
		}

		if (StringUtils.isNotBlank(filtro.getCep())) {

			criteria.add(Restrictions.ilike("cep", filtro.getCep(), MatchMode.ANYWHERE));
		}

		if (StringUtils.isNotBlank(filtro.getLogradouro())) {

			criteria.add(Restrictions.ilike("logradouro", filtro.getLogradouro(), MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotBlank(filtro.getUf())) {

			criteria.add(Restrictions.ilike("est.uf", filtro.getUf(), MatchMode.ANYWHERE));
		}

		return criteria.addOrder(Order.asc("id")).list();
	}
}
