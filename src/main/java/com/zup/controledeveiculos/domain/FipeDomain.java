package com.zup.controledeveiculos.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FipeDomain {
	
	@JsonProperty("Valor")
	private String valor;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
