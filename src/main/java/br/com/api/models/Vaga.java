package br.com.api.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.api.enums.VagaStatus;

@Entity
public class Vaga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer numero;

	private VagaStatus status;

	@OneToMany
	private List<Estacionamento> estacionadas;

	private Estacionamento ultimaEstacionada;
	
	public Vaga() {
		
	}

	public Vaga(Integer id, Integer numero, VagaStatus status) {
		super();
		this.id = id;
		this.setNumero(16);
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public VagaStatus getStatus() {
		return status;
	}

	public void setStatus(VagaStatus status) {
		this.status = status;
	}

	public List<Estacionamento> getEstacionadas() {
		return estacionadas;
	}

	public void setEstacionadas(List<Estacionamento> estacionadas) {
		this.estacionadas = estacionadas;
	}

	public Estacionamento getUltimaEstacionada() {
		return ultimaEstacionada;
	}

	public void setUltimaEstacionada(Estacionamento ultimaEstacionada) {
		this.ultimaEstacionada = ultimaEstacionada;
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
		Vaga other = (Vaga) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
