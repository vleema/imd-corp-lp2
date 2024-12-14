package com.leema.app.model;

import com.leema.app.model.enums.Nivel;

import java.time.LocalDate;
import java.util.List;

import com.leema.app.model.enums.Formacao;
import com.leema.app.model.enums.Genero;
import com.leema.app.model.interfaces.Funcionario;

public class Professor extends Pessoa implements Funcionario {

	private final Double salarioBase = 4000.0;

	private Nivel nivelProfessor;
	private Formacao formacaoProfessor;
	private List<String> disciplinas;

	public Professor(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco, Long matricula,
			Double salario, String departamento, Integer cargaHoraria, LocalDate dataIngresso, Nivel nivelProfessor,
			Formacao formacaoProfessor, List<String> disciplinas) {
		super(nome, cpf, dataNascimento, genero, endereco, matricula, salario, departamento, cargaHoraria, dataIngresso);
		this.nivelProfessor = nivelProfessor;
		this.formacaoProfessor = formacaoProfessor;
		this.disciplinas = disciplinas;
		setSalario(calcularSalario());
	}

	@Override
	public String toString() {
		return "* Nome: " + getNome() + '\n'
				+ "  · Matrícula: " + getMatricula() + '\n'
				+ "  . Formação: " + getFormacaoProfessor() + '\n'
				+ "  · Data de Ingresso: " + getDataIngresso() + '\n'
				+ "  · Salário: " + getSalario();
	}

	@Override
	public Double calcularSalario() {
		return salarioBase * nivelProfessor.getBonusProfessor() * formacaoProfessor.getBonus();
	}

	public Nivel getNivelProfessor() {
		return nivelProfessor;
	}

	public void setNivelProfessor(Nivel nivelProfessor) {
		this.nivelProfessor = nivelProfessor;
	}

	public Formacao getFormacaoProfessor() {
		return formacaoProfessor;
	}

	public void setFormacaoProfessor(Formacao formacaoProfessor) {
		this.formacaoProfessor = formacaoProfessor;
	}

	public List<String> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<String> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
