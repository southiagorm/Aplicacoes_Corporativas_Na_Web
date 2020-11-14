package br.com.aula.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.aula.dao.FuncionarioDAO;
import br.com.aula.enums.TipoTelefone;
import br.com.aula.exception.ServiceException;
import br.com.aula.model.Funcionario;
import br.com.aula.model.Telefone;
import br.com.aula.service.TelefoneService;

@Named
@ViewScoped
public class CadastrarTelefoneBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Telefone telefone;
	private FuncionarioDAO funcionarioDao;
	private TelefoneService telefoneService;
	private List<Funcionario> funcionarios;

	private String tipoTelefone;
	private long funcionarioId;
	
	public void pegarTipoTelefone() {
		if(!tipoTelefone.isEmpty()) {
			TipoTelefone t = (tipoTelefone.equals("RESIDENCIAL")) ? TipoTelefone.RESIDENCIAL : TipoTelefone.CELULAR;
			telefone.setTipoTelefone(t);
		}
		//System.out.println(t);
	}
	
	public void pegarFuncionario() {
		Funcionario f = funcionarioDao.findById(funcionarioId);
		telefone.setFuncionario(f);
		//System.out.println(f.getNome());
	}
	
	public void save() {
		try {
			telefoneService.save(telefone);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Telefone Cadastrado com Sucesso!", ""));
			
			telefone = new Telefone();
			tipoTelefone = "";
			funcionarioId = 0;
		}catch(ServiceException e) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	@PostConstruct
	public void init() {
		telefone = new Telefone();
		funcionarioDao = new FuncionarioDAO();
		telefoneService = new TelefoneService();
		funcionarios = funcionarioDao.findAll();
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public String getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

}
