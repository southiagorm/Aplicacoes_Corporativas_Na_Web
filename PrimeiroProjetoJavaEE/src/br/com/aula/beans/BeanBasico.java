package br.com.aula.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class BeanBasico {

	private String nome;
	private String mensagem;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public void exibirMensagem() {
		this.mensagem = "Bem vindo ao JSF: " + this.nome;
		System.out.println(mensagem);
	}

}
