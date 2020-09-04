package br.com.aula.models;

public class Pessoa {

	private String nome;
	private String email;
	private String cidade;

	public Pessoa(String nome, String email, String cidade) {
		super();
		this.nome = nome;
		this.email = email;
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
