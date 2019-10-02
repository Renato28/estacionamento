package br.com.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.api.dao.VagaDao;
import br.com.api.models.Vaga;

@Transactional
@Service
public class VagaServiceImpl implements VagaService {

	@Autowired
	private VagaDao vagaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Vaga> listarVagas() {
		return vagaDao.listar();
	}

	@Override
	public void salvar(Vaga vaga) {
		vagaDao.salvar(vaga);
	}

	@Override
	@Transactional(readOnly = true)
	public Vaga listarPorId(Integer id) {
		return vagaDao.listarPorId(id);
	}

	@Override
	public void atualizar(Vaga vaga) {
		vagaDao.atualizar(vaga);

	}

	@Override
	public void excluir(Integer id) {
		vagaDao.excluir(id);

	}

}
