package br.com.aula.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.aula.exception.ServiceException;
import br.com.aula.model.Funcionario;
import br.com.aula.service.FuncionarioService;

@Named
@RequestScoped
public class FuncionarioBean {

	private Funcionario funcionario;
	private FuncionarioService funcionarioService;
	
	public void save() {
		try {
			funcionarioService.save(funcionario);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Funcionário Cadastrado com Sucesso", ""));
		}catch(ServiceException e) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	@PostConstruct
	public void init() {
		funcionario = new Funcionario();
		funcionarioService = new FuncionarioService();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
