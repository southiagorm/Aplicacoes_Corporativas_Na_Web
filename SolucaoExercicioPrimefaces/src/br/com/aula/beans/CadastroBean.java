package br.com.aula.beans;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.aula.models.Pessoa;

@Named
@ApplicationScoped
public class CadastroBean {

	private ArrayList<Pessoa> pessoas;
	private Pessoa pessoa;

	@PostConstruct
	public void init() {
		pessoas = new ArrayList<Pessoa>();
		pessoa = new Pessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public void cadastrarPessoa() {
		if(pessoas.contains(pessoa)) {
			pessoas.set(pessoas.indexOf(pessoa), pessoa);
			this.pessoa = new Pessoa();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa Alterada com Sucesso", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}else {
			pessoas.add(pessoa);
			this.pessoa = new Pessoa();
			System.out.println(pessoas);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa Cadastrada com Sucesso", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void deletarPessoa(Pessoa pessoa) {
		this.pessoas.remove(pessoa);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa Removida com Sucesso", "");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void alterarPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
