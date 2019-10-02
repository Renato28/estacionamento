package br.com.api.services;

import java.util.List;

import br.com.api.models.Vaga;

public interface VagaService {

	void salvar(Vaga vaga);
	List<Vaga> listarVagas();
	Vaga listarPorId(Integer id);
	void atualizar(Vaga vaga);
	void excluir(Integer id);
	

}
