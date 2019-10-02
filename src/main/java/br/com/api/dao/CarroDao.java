package br.com.api.dao;

import java.util.List;

import br.com.api.models.Carro;

public interface CarroDao {

	void salvar(Carro carro);
	List<Carro> listar();
	Carro listarPorId(Integer id);
	void atualizar(Carro carro);
	void excluir(Integer id);
}
