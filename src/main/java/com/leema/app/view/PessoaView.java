package com.leema.app.view;

import java.time.LocalDate;
import java.util.List;

import com.leema.app.model.Endereco;
import com.leema.app.model.Pessoa;
import com.leema.app.model.enums.Genero;
import com.leema.app.util.InputUtils;
import com.leema.app.util.Pair;

public class PessoaView {

	public static String capturarNome() {
		System.out.print("Digite o nome do profisional: ");
		return InputUtils.lerString();
	}

	public static String capturarCPF() {
		System.out.print("Digite o cpf do profissional: ");
		return InputUtils.lerString();
	}

	public static LocalDate capturarDataDeNascimento() throws IllegalArgumentException {
		System.out.print("Digite a data de nascimento do profissonal no formato YYYY-MM-DD: ");
		return InputUtils.lerData();
	}

	public static Genero capturarGenero() throws IllegalArgumentException {
		System.out.print("Digite o gênero do profissional (Masculino, Feminino, Outro): ");
		return Genero.fromString(InputUtils.lerString());
	}

	public static Endereco capturarEndereco() {
		System.out.println("Digite o endereço do profissional: ");
		System.out.print(" * Rua: ");
		String rua = InputUtils.lerString();
		System.out.print(" * Número: ");
		Integer numero = InputUtils.lerInt();
		System.out.print(" * Bairro: ");
		String bairro = InputUtils.lerString();
		System.out.print(" * Cidade: ");
		String cidade = InputUtils.lerString();
		System.out.print(" * CEP: ");
		String cep = InputUtils.lerString();
		return new Endereco(rua, numero, bairro, cidade, cep);
	}

	public static Long capturarMatricula() {
		System.out.print("Digite a matrícula do profissional: ");
		return InputUtils.lerLong();
	}

	public static Double capturarSalario() {
		System.out.print("Digite o salário do profissional: ");
		return InputUtils.lerDouble();
	}

	public static String capturarDepartamamento() {
		System.out.print("Digite o departamento do profissional: ");
		return InputUtils.lerString();
	}

	public static Integer capturarCargaHoraria() {
		System.out.print("Digite a carga horaria do profissional: ");
		return InputUtils.lerInt();
	}

	public static LocalDate capturarDataDeIngresso() {
		System.out.print("Digite a data de ingresso do profissional (YYYY-MM-DD): ");
		return InputUtils.lerData();
	}

	public static Long capturarMatriculaParaRemocao(List<Pair<Pessoa, Integer>> pessoasMaisProximas) {
		System.out.println("Mostrando as " + pessoasMaisProximas.size() + " mais próximas: ");
		for (Pair<Pessoa, Integer> pessoa : pessoasMaisProximas) {
			System.out.println(pessoa.getKey().toString());
		}
		System.out.print("\nDigite a matrícula do profissonal que você quer deletar: ");
		return InputUtils.lerLong();
	}
}
