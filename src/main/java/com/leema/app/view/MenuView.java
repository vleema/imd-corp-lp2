package com.leema.app.view;

import java.util.ArrayList;
import java.util.Arrays;

import com.leema.app.util.InputUtils;

public class MenuView {
	public static int menuPrincipal() {
		System.out.println("Menu PRINCIPAL\n"
				+ "    1 - Cadastrar Funcionário\n"
				+ "    2 - Listar Funcionários\n"
				+ "    3 - Buscar Funcionário\n"
				+ "    4 - Remover Funcionário\n"
				+ "    0 - Salvar e sair.");
		System.out.print("Escolha uma opção: ");
		int opcao = InputUtils.lerInt();
		return opcao;
	}

	private static int menuFuncionario(String operacao) {
		System.out.println("Menu" + operacao);
		System.out.println("Que tipo Funcionário você deseja " + operacao + "?\n"
				+ "    1 - Professor\n"
				+ "    2 - TécnicoADM\n"
				+ "    3 - Abortar");
		System.out.print("Escolha uma opção: ");
		return InputUtils.lerInt();
	}

	private static int menuFuncionarioAlternativo(String operacao) {
		System.out.println("Menu " + operacao);
		System.out.println("Que tipo Funcionário você deseja " + operacao + "?\n"
				+ "    1 - Professor\n"
				+ "    2 - TécnicoADM\n"
				+ "    3 - Qualquer\n"
				+ "    4 - Abortar");
		System.out.print("Escolha uma opção: ");
		return InputUtils.lerInt();
	}

	public static int menuCadastrarFuncionario() {
		return menuFuncionario("CADASTRAR");
	}

	public static int menuListarFuncionario() {
		return menuFuncionarioAlternativo("LISTAR");
	}

	public static int menuBuscarFuncionario() {
		return menuFuncionarioAlternativo("BUSCAR");
	}

	public static int menuRemoverFuncionario() {
		return menuFuncionarioAlternativo("REMOVER");
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

	public static void pressioneEnterParaContinuar() {
		System.out.println("Pressione <Enter> para continuar...");
		InputUtils.lerString();
	}

	public static boolean desejaTentarNovamente() {
		System.out.print("Deseja tentar novamente? (S/n): ");
		String escolha = InputUtils.lerString();
		if (escolha.equalsIgnoreCase("s") || escolha.equalsIgnoreCase("sim")) {
			return true;
		}
		if (escolha.equalsIgnoreCase("n") || escolha.equalsIgnoreCase("não")) {
			return false;
		}
		return true;
	}

}
