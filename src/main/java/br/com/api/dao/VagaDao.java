package br.com.api.dao;

import java.util.List;

import br.com.api.models.Vaga;

public interface VagaDao {

	void salvar(Vaga vaga);
	List<Vaga> listar();
	Vaga listarPorId(Integer id);
	void atualizar(Vaga vaga);
	void excluir(Integer id);
}
