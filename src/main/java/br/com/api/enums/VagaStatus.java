package br.com.api.enums;

public enum VagaStatus {

	DISPONIVEL(1, "Disponivel"), OCUPADO(2, "Ocupado"), INDISPONIVEL(3, "Indisponivel");

	private int cod;
	private String descricao;

	private VagaStatus(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

}
