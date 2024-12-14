package com.leema.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.text.similarity.LevenshteinDistance;

import com.leema.app.dao.BancoDAO;
import com.leema.app.model.Pessoa;
import com.leema.app.util.Pair;

public class BancoService {

	public static List<Pair<Pessoa, Integer>> buscarPorNome_(final String nome, final int maximo) {
		final LevenshteinDistance levenshtein = new LevenshteinDistance();
		final Map<Pair<Pessoa, Integer>, Integer> distancias = new HashMap<>();

		ArrayList<Pessoa> banco = BancoDAO.getInstance().getFuncionarios();
		for (int i = 0; i < banco.size(); i++) {
			final Pessoa pessoaAtual = banco.get(i);
			final int distancia = levenshtein.apply(nome, pessoaAtual.getNome());
			distancias.put(new Pair<Pessoa, Integer>(pessoaAtual, i), distancia);
		}

		return distancias.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.limit(maximo)
				.map(Map.Entry::getKey)
				.toList();
	}

	public static List<Pessoa> buscarPorNome(final String nome, final int maximo) {
		final LevenshteinDistance levenshtein = new LevenshteinDistance();
		final Map<Pessoa, Integer> distancias = new HashMap<>();

		for (Pessoa pessoa : BancoDAO.getInstance().getFuncionarios()) {
			final int distancia = levenshtein.apply(nome, pessoa.getNome());
			distancias.put(pessoa, distancia);
		}

		return distancias.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.limit(maximo)
				.map(Map.Entry::getKey)
				.toList();
	}

	public static boolean removerFuncionario(int indice) {
		try {
			BancoDAO.getInstance().getFuncionarios().remove(indice);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
}
