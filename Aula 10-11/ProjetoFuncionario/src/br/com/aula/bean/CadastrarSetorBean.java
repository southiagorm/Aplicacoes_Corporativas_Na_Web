package br.com.aula.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.aula.dao.SetorDao;
import br.com.aula.exception.ServiceException;
import br.com.aula.model.Funcionario;
import br.com.aula.model.Setor;
import br.com.aula.service.SetorService;

@Named
@RequestScoped
public class CadastrarSetorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Setor setor;
	private SetorService setorService;

	public void save() {
		try {
			setorService.save(setor);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Setor Cadastrado com Sucesso", ""));
		} catch (ServiceException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		
		setor = new Setor();

	}
	
	@PostConstruct
	public void init() {
		this.setor = new Setor();
		this.setorService = new SetorService();
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

}
