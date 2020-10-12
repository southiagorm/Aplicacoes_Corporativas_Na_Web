package br.com.aula.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.aula.dao.FuncionarioDAO;
import br.com.aula.exception.ServiceException;
import br.com.aula.model.Funcionario;
import br.com.aula.service.FuncionarioService;

@Named
@ViewScoped
public class CadastrarFuncionarioBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Funcionario funcionario;
	private FuncionarioDAO funcionarioDao;
	private FuncionarioService funcionarioService;
	private int urlParamId;
	
	public void buscarFuncionario() {
		funcionario = funcionarioDao.findById(new Long(urlParamId));
		
	}

	public void save() {
		if(urlParamId == 0) {
			try {
				funcionarioService.save(funcionario);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Funcionário Cadastrado com Sucesso", ""));
			} catch (ServiceException e) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			}
		}else {
			funcionarioDao.update(funcionario);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Funcionário Atualizado com Sucesso", ""));
		}
		
	}

	@PostConstruct
	public void init() {
		funcionario = new Funcionario();
		funcionarioDao = new FuncionarioDAO();
		funcionarioService = new FuncionarioService();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public int getUrlParamId() {
		return urlParamId;
	}

	public void setUrlParamId(int urlParamId) {
		this.urlParamId = urlParamId;
	}

}
