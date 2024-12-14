package com.leema.app.view;

import java.util.ArrayList;
import java.util.Arrays;

import com.leema.app.model.enums.Formacao;
import com.leema.app.model.enums.Nivel;
import com.leema.app.util.InputUtils;

public class ProfessorView {

	public static Nivel capturarNivel() throws IllegalArgumentException {
		System.out.print("Digite o nível na progressão salarial (I-VIII): ");
		return Nivel.fromString(InputUtils.lerString());
	}

	public static Formacao capturarFormacao() throws IllegalArgumentException {
		System.out.print("Digite o nível de formação do profissional (ESPECIALIZACAO, MESTRADO, DOUTORADO): ");
		return Formacao.fromString(InputUtils.lerString());
	}

	public static ArrayList<String> capturarDisciplinas() {
		System.out.print("Digite as disciplinas lecionadas (separadas por vírgula): ");
		ArrayList<String> disciplinas = new ArrayList<String>(
				Arrays.asList(InputUtils.lerString().split(",")));
		for (String disciplinaStr : disciplinas) {
			disciplinaStr.trim();
		}
		return disciplinas;
	}
}
