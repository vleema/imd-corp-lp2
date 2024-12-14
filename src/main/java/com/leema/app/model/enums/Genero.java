package com.leema.app.model.enums;

public enum Genero {
	MASCULINO, FEMININO, OUTRO, INDEFINIDO;

	public static Genero fromString(String generoStr) {
		for (Genero genero : Genero.values()) {
			if (!genero.equals(INDEFINIDO) && genero.name().equalsIgnoreCase(generoStr)) {
				return genero;
			}
		}
		throw new IllegalArgumentException("Valor inválido para Gênero.");
	}
}
