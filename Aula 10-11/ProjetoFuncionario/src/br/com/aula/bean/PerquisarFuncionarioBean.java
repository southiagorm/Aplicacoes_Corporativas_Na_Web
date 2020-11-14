package br.com.aula.bean;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.aula.dao.FuncionarioDAO;
import br.com.aula.dao.LazyFuncionarioDatabase;
import br.com.aula.model.Funcionario;

@Named
@RequestScoped
public class PerquisarFuncionarioBean {

	private FuncionarioDAO funcionarioDao;
	private List<Funcionario> funcionarios;
	
	private LazyFuncionarioDatabase lazyFuncionarios;
	
	public void remover(Funcionario funcionario) {
		funcionarioDao.remove(funcionario);
		funcionarios.remove(funcionario);
	}
	
	public String atualizar(Funcionario funcionario) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("funcionario", funcionario);
		return "cadastroFuncionario.xhtml?faces-redirect=true";
	}

	@PostConstruct
	public void init() {
		funcionarioDao = new FuncionarioDAO();
		//funcionarios = funcionarioDao.findAll();
		lazyFuncionarios = new LazyFuncionarioDatabase(funcionarioDao);
	}

	public List<Funcionario> getFuncionarios() {
		return Collections.unmodifiableList(funcionarios);
	}

	public LazyFuncionarioDatabase getLazyFuncionarios() {
		return lazyFuncionarios;
	}

}
