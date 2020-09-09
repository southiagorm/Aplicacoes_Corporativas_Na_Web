package br.com.aula.beans;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@ApplicationScoped
public class CriptografarBean {

	private String nome;
	private String nomeCriptografado;
	private String nomeComboBox;

	private ArrayList<String> nomes;

	@PostConstruct
	public void init() {
		nomes = new ArrayList<String>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeCriptografado() {
		return nomeCriptografado;
	}

	public void setNomeCriptografado(String nomeCriptografado) {
		this.nomeCriptografado = nomeCriptografado;
	}

	public ArrayList<String> getNomes() {
		return nomes;
	}

	public String getNomeComboBox() {
		return nomeComboBox;
	}

	public void setNomeComboBox(String nomeComboBox) {
		this.nomeComboBox = nomeComboBox;
	}

	public void criptografar() {
		StringBuilder nomeTemp = new StringBuilder();

		for (int i = 0; i < nome.length(); i++) {
			char letra = (char) ((char) ((int) nome.charAt(i)) + 1);
			nomeTemp.append(letra);
		}

		nomeCriptografado = nomeTemp.toString();
	}

	public void validar() {
		if (nomes.isEmpty() || !nomes.contains(nome)) {
			nomes.add(nome);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Validado com Sucesso!", ""));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Esse nome já existe!", "Erro de Validação!"));
		}
		System.out.println(nomes);
	}
	
	public void exibirNome() {
		System.out.println(nomeComboBox);
	}

}
