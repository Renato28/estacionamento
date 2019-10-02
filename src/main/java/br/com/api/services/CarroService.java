package br.com.api.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.api.models.Carro;
import br.com.api.models.Estacionamento;

public interface CarroService {
	
	void salvar(Carro carro);
	List<Carro> listar();
	Carro listarPorId(Integer id);
	void atualizar(Carro carro);
	void excluir(Integer id);

	public BigDecimal calcularDiferenca(Date data1, Date data2);

	public BigDecimal calcularPagamento(BigDecimal precoHora, BigDecimal hora);
	
	public BigDecimal emitirRelatorio(BigDecimal carros, List<Estacionamento> vagas);
}
