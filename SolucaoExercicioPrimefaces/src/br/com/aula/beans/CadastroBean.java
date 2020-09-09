package br.com.aula.beans;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
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
		pessoas.add(pessoa);
		this.pessoa = new Pessoa();
		System.out.println(pessoas);
	}

}
