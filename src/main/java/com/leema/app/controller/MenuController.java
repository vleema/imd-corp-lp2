package com.leema.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.leema.app.dao.BancoDAO;
import com.leema.app.view.MenuView;
import com.leema.app.view.PessoaView;
import com.leema.app.model.Professor;
import com.leema.app.model.TecnicoADM;
import com.leema.app.model.enums.TipoDeFuncionario;
import com.leema.app.service.BancoService;
import com.leema.app.util.Pair;
import com.leema.app.model.Pessoa;

public class MenuController {
	public static void executar() {
		int opcao;
		boolean querSair = false;
		while (!querSair) {
			try {
				limparTerminal();
				opcao = MenuView.menuPrincipal();
				switch (opcao) {
					case 1 -> cadastrarFuncionario();
					case 2 -> listarFuncionarios();
					case 3 -> buscarFuncionario();
					case 4 -> removerFuncionario();
					case 0 -> {
						System.out.println("Até a próxima!");
						querSair = true;
					}
					default -> {
						System.out.println("Opção inválida, tente novamente...");
						MenuView.pressioneEnterParaContinuar();
					}
				}
			} catch (final Exception e) {
				System.out.println("Erro ao processar entrada, tente novamente...");
				MenuView.pressioneEnterParaContinuar();
			}
		}
	}

	private static void removerFuncionario() {
		while (true) {
			try {
				limparTerminal();
				int opcao = MenuView.menuRemoverFuncionario();
				TipoDeFuncionario tipoDeFuncionario = TipoDeFuncionario.Indefinido;
				if (opcao == 1) {
					tipoDeFuncionario = TipoDeFuncionario.Professor;
				} else if (opcao == 2) {
					tipoDeFuncionario = TipoDeFuncionario.TecnicoADM;
				} else if (opcao == 3) {
					tipoDeFuncionario = TipoDeFuncionario.Indefinido;
				} else if (opcao == 4) {
					System.out.println("Abortando operação...");
					break;
				}

				String nome = PessoaView.capturarNome();
				List<Pair<Pessoa, Integer>> pessoasMaisProximas = PessoaController.filtrarPorTipo(tipoDeFuncionario,
						BancoService.buscarPorNome_(nome, 5));

				Long matricula = PessoaView.capturarMatriculaParaRemocao(pessoasMaisProximas);
				Optional<Integer> indiceParaRemocao = PessoaController.procurarMatricula(matricula, pessoasMaisProximas);

				BancoService.removerFuncionario(indiceParaRemocao.orElseThrow());
				System.out.println("Funcionário removido com sucesso! ");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Erro ao processar entrada, tente novamente...");
			} catch (NoSuchElementException e) {
				System.out.println("Erro, Mátricula não encontrada.");
				if (!MenuView.desejaTentarNovamente())
					break;
			}
			MenuView.pressioneEnterParaContinuar();
		}
	}

	private static void buscarFuncionario() {
		boolean sair = false;
		while (!sair) {
			try {
				limparTerminal();
				int opcao = MenuView.menuBuscarFuncionario();
				switch (opcao) {
					case 1 -> {
						String nome = PessoaView.capturarNome();
						List<Pessoa> pessoasMaisProximas = BancoService.buscarPorNome(nome, 5);
						ArrayList<Professor> professores = filtrarProfessores(pessoasMaisProximas);
						System.out.println("Exibindo os 5 resultados mais próximos: ");
						for (Professor professor : professores) {
							System.out.println(professor.toString() + '\n');
						}
						MenuView.pressioneEnterParaContinuar();
					}
					case 2 -> {
						String nome = PessoaView.capturarNome();
						List<Pessoa> pessoasMaisProximas = BancoService.buscarPorNome(nome, 5);
						ArrayList<TecnicoADM> tecnicos = filtrarTecnicosADM(pessoasMaisProximas);
						System.out.println("Exibindo os 5 resultados mais próximos: ");
						for (TecnicoADM tecnico : tecnicos) {
							System.out.println(tecnico.toString() + '\n');
						}
						MenuView.pressioneEnterParaContinuar();
					}
					case 3 -> {
						String nome = PessoaView.capturarNome();
						List<Pessoa> pessoasMaisProximas = BancoService.buscarPorNome(nome, 5);
						System.out.println("Exibindo os 5 resultados mais próximos: ");
						for (Pessoa pessoa : pessoasMaisProximas) {
							System.out.println(pessoa.toString());
						}
						MenuView.pressioneEnterParaContinuar();
					}
					case 4 -> {
						sair = true;
					}
					default -> {
						System.out.println("Opção inválida, tente novamente...");
						MenuView.pressioneEnterParaContinuar();
					}
				}
			} catch (final Exception e) {
				System.out.println("Erro ao processar entrada, tente novamente...");
				MenuView.pressioneEnterParaContinuar();
			}
		}
	}

	private static void listarFuncionarios() {
		boolean sair = false;
		while (!sair) {
			try {
				limparTerminal();
				int opcao = MenuView.menuListarFuncionario();
				switch (opcao) {
					case 1 -> {
						for (Professor professor : filtrarProfessores(BancoDAO.getInstance().getFuncionarios())) {
							System.out.println(professor.toString());
						}
						MenuView.pressioneEnterParaContinuar();
					}
					case 2 -> {
						for (TecnicoADM tecnicoADM : filtrarTecnicosADM(BancoDAO.getInstance().getFuncionarios())) {
							System.out.println(tecnicoADM.toString());
						}
						MenuView.pressioneEnterParaContinuar();
					}
					case 3 -> {
						for (Pessoa pessoa : BancoDAO.getInstance().getFuncionarios()) {
							System.out.println(pessoa.toString());
						}
						MenuView.pressioneEnterParaContinuar();
					}
					case 4 -> {
						sair = true;
					}
					default -> {
						System.out.println("Opção inválida, tente novamente...");
						MenuView.pressioneEnterParaContinuar();
					}
				}
			} catch (final Exception e) {
				System.out.println("Erro ao processar entrada, tente novamente...");
				MenuView.pressioneEnterParaContinuar();
			}
		}
	}

	private static void cadastrarFuncionario() {
		boolean sair = false;
		while (!sair) {
			try {
				limparTerminal();
				int opcao = MenuView.menuCadastrarFuncionario();
				switch (opcao) {
					case 1 -> ProfessorController.cadastrarProfessor();
					case 2 -> TecnicoADMController.cadastrarTecnico();
					case 3 -> {
						System.out.println("Abortando...");
						sair = true;
					}
					default -> {
						System.out.println("Opção inválida, tente novamente.");
						MenuView.pressioneEnterParaContinuar();
					}
				}
			} catch (final Exception e) {
				System.out.println("Erro ao processar a entrada, tente novamente: ");
				MenuView.pressioneEnterParaContinuar();
			}
		}
	}

	private static ArrayList<TecnicoADM> filtrarTecnicosADM(List<Pessoa> lista) {
		ArrayList<TecnicoADM> listaFiltrada = new ArrayList<>();
		for (Pessoa pessoa : lista) {
			if (pessoa instanceof TecnicoADM) {
				listaFiltrada.add((TecnicoADM) pessoa);
			}
		}
		return listaFiltrada;
	}

	private static ArrayList<Professor> filtrarProfessores(List<Pessoa> lista) {
		ArrayList<Professor> listaFiltrada = new ArrayList<>();
		for (Pessoa pessoa : lista) {
			if (pessoa instanceof Professor) {
				listaFiltrada.add((Professor) pessoa);
			}
		}
		return listaFiltrada;
	}

	private static void limparTerminal() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				new ProcessBuilder("clear").inheritIO().start().waitFor();
			}
		} catch (final Exception e) {
			System.out.println("Error ao limpar o terminal" + e.getMessage());
		}
	}
}
