package com.leema.app.controller;

import java.util.List;
import java.util.Optional;

import com.leema.app.util.Pair;
import com.leema.app.model.Pessoa;
import com.leema.app.model.TecnicoADM;
import com.leema.app.model.Professor;
import com.leema.app.model.enums.TipoDeFuncionario;

/**
 * PessoaController
 */
public class PessoaController {

	public static Optional<Integer> procurarMatricula(Long matricula, List<Pair<Pessoa, Integer>> pessoas) {
		return pessoas.stream()
				.filter(pessoaIndice -> pessoaIndice.getKey().getMatricula().equals(matricula))
				.map(Pair::getValue)
				.findFirst();
	}

	public static List<Pair<Pessoa, Integer>> filtrarPorTipo(TipoDeFuncionario tipoDeFuncionario,
			List<Pair<Pessoa, Integer>> pessoas) {
		if (tipoDeFuncionario == TipoDeFuncionario.TecnicoADM) {
			return pessoas.stream()
					.filter(pessoaIndice -> pessoaIndice.getKey() instanceof TecnicoADM)
					.toList();
		}
		if (tipoDeFuncionario == TipoDeFuncionario.Professor) {
			return pessoas.stream()
					.filter(pessoaIndice -> pessoaIndice.getKey() instanceof Professor)
					.toList();
		}
		return pessoas;
	}

}
