package com.movile.zeroQ.financial.domain;

public enum Status {

	ATIVO("ATIVO"), PAGA("PAGA"), SOLICITADA("SOLICITADA");

	private String description;

	private Status(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
