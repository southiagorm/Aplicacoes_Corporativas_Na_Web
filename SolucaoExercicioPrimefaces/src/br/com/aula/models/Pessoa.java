package br.com.aula.models;

import java.util.Date;

public class Pessoa {

	private String nome;
	private String email;
	private Date dataNascimento;
	private String cpf;

	public Pessoa() {

	}

	public Pessoa(String nome, String email, Date date, String cpf) {
		super();
		this.nome = nome;
		this.email = email;
		this.dataNascimento = date;
		this.cpf = cpf;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", email=" + email + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf
				+ "]";
	}

}
