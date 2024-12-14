package com.leema.app;

import com.leema.app.controller.MenuController;
import com.leema.app.dao.BancoDAO;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		BancoDAO.getInstance().carregarBancoDAO("banco.dat");
		MenuController.executar();
		BancoDAO.getInstance().salvarBancoDAO("banco.dat");
	}
}
