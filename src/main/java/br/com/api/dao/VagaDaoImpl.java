package br.com.api.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.api.models.Vaga;

@Repository
public class VagaDaoImpl implements VagaDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void salvar(Vaga vaga) {
		em.persist(vaga);
		
	}

	@Override
	public List<Vaga> listar() {
		return em.createQuery("select v from Vaga v", Vaga.class).getResultList();
		
	}

	@Override
	public Vaga listarPorId(Integer id) {
		return em.find(Vaga.class, id);

	}

	@Override
	public void atualizar(Vaga vaga) {
		em.merge(vaga);
		
	}

	@Override
	public void excluir(Integer id) {
		em.remove(em.getReference(Vaga.class, id));
		
	}

	
}
