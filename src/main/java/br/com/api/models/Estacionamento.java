package br.com.api.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estacionamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany
	private Carro carros;

	@OneToMany
	private Vaga vaga;

	private Double preco;

	public Integer getId() {
		return id;
	}

	public Estacionamento() {

	}

	public Estacionamento(Integer id, Carro carro, Vaga vaga, Double preco) {
		this.id = id;
		this.carros = carro;
		this.vaga = vaga;
		this.preco = preco;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Carro getCarros() {
		return carros;
	}

	public void setCarros(Carro carros) {
		this.carros = carros;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacionamento other = (Estacionamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
