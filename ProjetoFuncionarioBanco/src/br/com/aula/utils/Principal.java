package br.com.aula.utils;

import javax.persistence.EntityManager;

import br.com.aula.dao.FuncionarioDAO;
import br.com.aula.dao.TelefoneDAO;
import br.com.aula.enums.TipoTelefone;
import br.com.aula.model.CarteiraTrabalho;
import br.com.aula.model.Funcionario;
import br.com.aula.model.Setor;
import br.com.aula.model.Telefone;

public class Principal {

	public static void main(String[] args) {

		Funcionario funcionario1 = new FuncionarioDAO().findById(2L);

		CarteiraTrabalho carteira = new CarteiraTrabalho("123AA", 12345, 23, "PB");

		funcionario1.setCarteira(carteira);

		new FuncionarioDAO().update(funcionario1);

	}

}
