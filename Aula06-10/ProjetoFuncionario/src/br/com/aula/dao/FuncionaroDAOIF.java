package br.com.aula.dao;

import br.com.aula.model.Funcionario;

public interface FuncionaroDAOIF extends GenericDAOIF<Funcionario> {
	
	Funcionario findByMatricula(String matricula);
	
}
