package br.com.aula.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.aula.dao.FuncionarioDAO;
import br.com.aula.dao.SetorDao;
import br.com.aula.exception.ServiceException;
import br.com.aula.model.Funcionario;
import br.com.aula.model.Setor;
import br.com.aula.service.FuncionarioService;

@Named
@ViewScoped
public class CadastrarFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Funcionario funcionario;
	private FuncionarioDAO funcionarioDao;
	private FuncionarioService funcionarioService;
	private int urlParamId;
	private boolean fSession = false;

	private SetorDao setorDao;
	private List<Setor> setores;
	private int setorId;

	public void buscarFuncionario() {
		funcionario = funcionarioDao.findById(new Long(urlParamId));
		if (funcionario != null) {
			if (urlParamId == 0 && funcionario.getSetores().isEmpty()) {
				funcionario = new Funcionario();
			} else {
				funcionario = new Funcionario();
			}
		}
	}

	public void save() {
		if (fSession == false) {
			try {
				funcionarioService.save(funcionario);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Funcionário Cadastrado com Sucesso", ""));
			} catch (ServiceException e) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			}
		} else {
			funcionarioDao.update(funcionario);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Funcionário Atualizado com Sucesso", ""));
		}

		funcionario = new Funcionario();

	}

	@PostConstruct
	public void init() {
		funcionarioDao = new FuncionarioDAO();
		funcionarioService = new FuncionarioService();

		Funcionario f = (Funcionario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("funcionario");
		if (f == null) {
			funcionario = new Funcionario();
		} else {
			funcionario = funcionarioDao.findFuncionariosAndSetores(f);
			fSession = true;
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("funcionario");
		}
		
		setorDao = new SetorDao();
		setores = setorDao.findAll();
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

	public boolean isfSession() {
		return fSession;
	}

	public int getSetorId() {
		return setorId;
	}

	public void setSetorId(int setorId) {
		this.setorId = setorId;
	}

	public List<Setor> getSetores() {
		return setores;
	}

	public void addSetorFuncionario() {
		Setor setor = setorDao.findById((long) setorId);
		funcionario.addSetor(setor);
		System.out.println(funcionario.getSetores());
	}

}
