package com.leema.app.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import com.leema.app.dao.BancoDAO;
import com.leema.app.model.Endereco;
import com.leema.app.model.Professor;
import com.leema.app.model.enums.Formacao;
import com.leema.app.model.enums.Genero;
import com.leema.app.model.enums.Nivel;
import com.leema.app.view.MenuView;
import com.leema.app.view.PessoaView;
import com.leema.app.view.ProfessorView;

public class ProfessorController {
	public static void cadastrarProfessor() {
		do {
			try {
				String nome = PessoaView.capturarNome();
				String cpf = PessoaView.capturarCPF();
				LocalDate dataDeNascimento = PessoaView.capturarDataDeNascimento();
				Genero genero = PessoaView.capturarGenero();
				Endereco endereco = PessoaView.capturarEndereco();
				Long matricula = PessoaView.capturarMatricula();
				Double salario = PessoaView.capturarSalario();
				String departamento = PessoaView.capturarDepartamamento();
				Integer cargaHoraria = PessoaView.capturarCargaHoraria();
				LocalDate dataDeIngresso = PessoaView.capturarDataDeIngresso();
				Nivel nivel = ProfessorView.capturarNivel();
				Formacao formacao = ProfessorView.capturarFormacao();
				ArrayList<String> disciplinas = MenuView.capturarDisciplinas();
				BancoDAO.getInstance().getFuncionarios().add(new Professor(
						nome, cpf, dataDeNascimento, genero, endereco, matricula, salario, departamento, cargaHoraria,
						dataDeIngresso, nivel, formacao, disciplinas));
				System.out.println("Professor cadastrado com sucesso!");
				MenuView.pressioneEnterParaContinuar();
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Entrada inválida. Tente novamente.");
			} catch (Exception e) {
				System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
			}
		} while (MenuView.desejaTentarNovamente());
	}
}
