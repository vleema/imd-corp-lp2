package com.leema.app.model.enums;

public enum Formacao {
	ESPECIALIZACAO(0.25), MESTRADO(0.50), DOUTORADO(0.75);

	private final Double bonus;

	private Formacao(Double bonus) {
		this.bonus = bonus;
	}

	public static Formacao fromString(String formacaoStr) {
		for (Formacao formacao : Formacao.values()) {
			if (formacao.name().equalsIgnoreCase(formacaoStr)) {
				return formacao;
			}
		}
		throw new IllegalArgumentException("Valor inválido para Formação");
	}

	public Double getBonus() {
		return bonus;
	}
}
