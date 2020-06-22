package com.algaworks.osworks.api.model;

import java.time.OffsetDateTime;

public class ComentarioModel {

	private Long id;
	private String descricao;
	private OffsetDateTime dateEnvio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public OffsetDateTime getDateEnvio() {
		return dateEnvio;
	}

	public void setDateEnvio(OffsetDateTime dateEnvio) {
		this.dateEnvio = dateEnvio;
	}

}
