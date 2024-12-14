package com.leema.app.model;

import java.time.LocalDate;

import com.leema.app.model.enums.Formacao;
import com.leema.app.model.enums.Genero;
import com.leema.app.model.enums.Nivel;
import com.leema.app.model.interfaces.Funcionario;

public class TecnicoADM extends Pessoa implements Funcionario {

	private final Double salarioBase = 2500.0;

	private Nivel nivelTecnico;
	private Formacao formacaoTecnico;
	private Boolean insalubridade;
	private Boolean funcaoGratificada;

	public TecnicoADM(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco, Long matricula,
			Double salario, String departamento, Integer cargaHoraria, LocalDate dataIngresso, Nivel nivelTecnico,
			Formacao formacaoTecnico, Boolean insalubridade, Boolean funcaoGratificada) {
		super(nome, cpf, dataNascimento, genero, endereco, matricula, salario, departamento, cargaHoraria, dataIngresso);
		this.nivelTecnico = nivelTecnico;
		this.formacaoTecnico = formacaoTecnico;
		this.insalubridade = insalubridade;
		this.funcaoGratificada = funcaoGratificada;
		setSalario(calcularSalario());
	}

	@Override
	public String toString() {
		return "* Nome: " + getNome() + '\n'
				+ "  · Matrícula: " + getMatricula() + '\n'
				+ "  . Formação: " + getFormacaoTecnico() + '\n'
				+ "  · Data de Ingresso: " + getDataIngresso() + '\n'
				+ "  · Salário: " + getSalario();
	}

	@Override
	public Double calcularSalario() {
		return salarioBase * nivelTecnico.getBonusTecnico() * formacaoTecnico.getBonus();
	}

	public Nivel getNivelTecnico() {
		return nivelTecnico;
	}

	public void setNivelTecnico(Nivel nivelTecnico) {
		this.nivelTecnico = nivelTecnico;
	}

	public Formacao getFormacaoTecnico() {
		return formacaoTecnico;
	}

	public void setFormacaoTecnico(Formacao formacaoTecnico) {
		this.formacaoTecnico = formacaoTecnico;
	}

	public Boolean getInsalubridade() {
		return insalubridade;
	}

	public void setInsalubridade(Boolean insalubridade) {
		this.insalubridade = insalubridade;
	}

	public Boolean getFuncaoGratificada() {
		return funcaoGratificada;
	}

	public void setFuncaoGratificada(Boolean funcaoGratificada) {
		this.funcaoGratificada = funcaoGratificada;
	}

}
