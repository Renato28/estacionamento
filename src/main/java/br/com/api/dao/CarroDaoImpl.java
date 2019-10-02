package br.com.api.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.api.models.Carro;

@Repository
public class CarroDaoImpl implements CarroDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void salvar(Carro carro) {
		em.persist(carro);

	}

	@Override
	public List<Carro> listar() {
		return em.createQuery("select c from Carro c", Carro.class).getResultList();
	}

	@Override
	public Carro listarPorId(Integer id) {
		return em.find(Carro.class, id);
	}

	@Override
	public void atualizar(Carro carro) {
		em.merge(carro);

	}

	@Override
	public void excluir(Integer id) {
		em.remove(em.getReference(Carro.class, id));

	}

}
