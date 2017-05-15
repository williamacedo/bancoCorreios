package teste;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.correios.modelos.Bairro;
import br.com.correios.modelos.Cidade;
import br.com.correios.modelos.Estado;

public class teste {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CorreiosPU");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		
		trx.begin();

//		Estado estado = new Estado();
//		Bairro bairro = new Bairro();
//		Cidade cidade = new Cidade();
		
		
		trx.commit();
	}
}
