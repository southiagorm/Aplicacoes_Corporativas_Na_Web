package br.com.aula.utils;

import br.com.aula.dao.TelefoneDAO;
import br.com.aula.model.Telefone;

public class Principal {
	
	public static void main(String[] args) {
	
		System.out.println("Teste");
		
		TelefoneDAO telefoneDao = new TelefoneDAO();
		
		Telefone telefone = telefoneDao.findById(1L);
		
		telefoneDao.remove(telefone);
	
	}

}
