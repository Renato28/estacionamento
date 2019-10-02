package br.com.api.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.api.dao.CarroDao;
import br.com.api.models.Carro;
import br.com.api.models.Estacionamento;

@Service
public class CarroServiceImpl implements CarroService{
	
	@Autowired
	private CarroDao carroDao;

	@Override
	public BigDecimal calcularDiferenca(Date horarioEntrada, Date horarioSaida) {
		
		DateTime entrada = new DateTime(horarioEntrada);
		DateTime saida = new DateTime(horarioSaida);
		
		BigDecimal minutos = new BigDecimal(Minutes.minutesBetween(entrada, saida).getMinutes());
		BigDecimal horas = minutos.divide(new BigDecimal("60"), 2, RoundingMode.HALF_UP);
		return horas;
	}

	@Override
	public BigDecimal calcularPagamento(BigDecimal precoHora, BigDecimal horas) {
		
		BigDecimal totalPagar = precoHora.multiply(horas);
		return totalPagar;
	}
	
	public BigDecimal emitirRelatorio(BigDecimal totalCarros, BigDecimal valorTotal) {
		
		
		BigDecimal totalPagamentos = totalCarros.multiply(valorTotal);
		return totalPagamentos;
	}

	@Override
	public void salvar(Carro carro) {
		
		carroDao.salvar(carro);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Carro> listar() {
		return carroDao.listar();
	}

	@Override
	@Transactional(readOnly = true)
	public Carro listarPorId(Integer id) {
		return carroDao.listarPorId(id);
	}

	@Override
	public void atualizar(Carro carro) {
		carroDao.atualizar(carro);
		
	}

	@Override
	public void excluir(Integer id) {
		carroDao.excluir(id);
		
	}

	@Override
	public BigDecimal emitirRelatorio(BigDecimal carros, List<Estacionamento> vagas) {
		
		BigDecimal totalPagamentos = carros.multiply((BigDecimal) vagas);
		return totalPagamentos;
	}

	
}
