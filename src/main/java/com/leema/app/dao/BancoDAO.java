package com.leema.app.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.leema.app.model.Pessoa;

public class BancoDAO {
	private static BancoDAO banco;
	private final ArrayList<Pessoa> funcionarios;

	private BancoDAO() {
		this.funcionarios = new ArrayList<>();
	}

	public ArrayList<Pessoa> getFuncionarios() {
		return funcionarios;
	}

	public static BancoDAO getInstance() {
		if (banco == null) {
			banco = new BancoDAO();
		}
		return banco;
	}

	public void carregarBancoDAO(String nomeDoArquivo) {
		File arquivo = new File(nomeDoArquivo);
		if (arquivo.exists() && arquivo.isFile()) {
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeDoArquivo))) {
				this.funcionarios.clear();
				this.funcionarios.addAll((ArrayList<Pessoa>) in.readObject());
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public void salvarBancoDAO(String nomeDoArquivo) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeDoArquivo))) {
			out.writeObject(this.funcionarios);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
