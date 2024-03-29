package br.com.api.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Carro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	private String modelo;

	@NotBlank
	private String ano;

	@NotBlank
	private String cor;

	@NotNull
	@JsonFormat(pattern = "#,##0.00")
	private BigDecimal precoHora;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date horarioEntrada;

	@JsonFormat(pattern = "#,##0.00")
	private BigDecimal totPagar;

	public Carro() {

	}

	public Carro(Integer id, String modelo, String ano, String cor, BigDecimal precoHora, Date horarioEntrada,
			BigDecimal totPagar) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.precoHora = precoHora;
		this.horarioEntrada = horarioEntrada;
		this.totPagar = totPagar;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Date getHorarioEntrada() {
		return horarioEntrada;
	}

	public void setHorarioEntrada(Date horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public BigDecimal getPrecoHora() {
		return precoHora;
	}

	public void setPrecoHora(BigDecimal precoHora) {
		this.precoHora = precoHora;
	}

	public BigDecimal getTotPagar() {
		return totPagar;
	}

	public void setTotPagar(BigDecimal totPagar) {
		this.totPagar = totPagar;
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
		Carro other = (Carro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
