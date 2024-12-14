package com.leema.app.model.enums;

public enum Nivel {
	I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8);

	private final Double bonusProfessor = 1.05;
	private final Double bonusTecnico = 1.03;
	private final int nivel;

	private Nivel(int nivel) {
		this.nivel = nivel;
	}

	public static Nivel fromString(String nivelStr) {
		for (Nivel nivel : Nivel.values()) {
			if (nivel.name().equalsIgnoreCase(nivelStr)) {
				return nivel;
			}
		}
		throw new IllegalArgumentException("Valor inválido para nível.");
	}

	public Double getBonusProfessor() {
		return Math.pow(bonusProfessor, nivel);
	}

	public Double getBonusTecnico() {
		return Math.pow(bonusTecnico, nivel);
	}
}
