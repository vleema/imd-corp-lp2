package com.leema.app.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.leema.app.model.enums.Genero;

public abstract class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private Genero genero;
	private Endereco endereco;
	private Long matricula;
	private Double salario;
	private String departamento;
	private Integer cargaHoraria;
	private LocalDate dataIngresso;

	public Pessoa(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco, Long matricula,
			Double salario, String departamento, Integer cargaHoraria, LocalDate dataIngresso) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.endereco = endereco;
		this.matricula = matricula;
		this.salario = salario;
		this.departamento = departamento;
		this.cargaHoraria = cargaHoraria;
		this.dataIngresso = dataIngresso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public LocalDate getDataIngresso() {
		return dataIngresso;
	}

	public void setDataIngresso(LocalDate dataIngresso) {
		this.dataIngresso = dataIngresso;
	}

}
