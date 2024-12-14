package com.leema.app.view;

import com.leema.app.util.InputUtils;

public class TecnicoADMView {
	public static Boolean capturarInsalubridade() {
		final Boolean opcaoPadrao = false;
		System.out.print("O técnico é insalubre? (s/N)");
		String escolha = InputUtils.lerString();
		if (escolha.equalsIgnoreCase("s") || escolha.equalsIgnoreCase("sim")) {
			return true;
		}
		if (escolha.equalsIgnoreCase("n") || escolha.equalsIgnoreCase("não")) {
			return false;
		}
		return opcaoPadrao;
	}

	public static Boolean capturarFuncaoGratificada() {
		final Boolean opcaoPadrao = true;
		System.out.print("A função do técnico é gratificada? (S/n)");
		String escolha = InputUtils.lerString();
		if (escolha.equalsIgnoreCase("s") || escolha.equalsIgnoreCase("sim")) {
			return true;
		}
		if (escolha.equalsIgnoreCase("n") || escolha.equalsIgnoreCase("não")) {
			return false;
		}
		return opcaoPadrao;
	}
}
