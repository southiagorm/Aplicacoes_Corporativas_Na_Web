package br.com.aula.bean;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.aula.dao.FuncionarioDAO;
import br.com.aula.model.Funcionario;

@Named
@RequestScoped
public class PerquisarFuncionarioBean {

	private FuncionarioDAO funcionarioDao;
	private List<Funcionario> funcionarios;
	
	public void remover(Funcionario funcionario) {
		funcionarioDao.remove(funcionario);
		funcionarios.remove(funcionario);
	}

	@PostConstruct
	public void init() {
		funcionarioDao = new FuncionarioDAO();
		funcionarios = funcionarioDao.findAll();
	}

	public List<Funcionario> getFuncionarios() {
		return Collections.unmodifiableList(funcionarios);
	}

}
