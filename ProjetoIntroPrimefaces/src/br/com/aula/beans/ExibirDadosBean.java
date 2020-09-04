package br.com.aula.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.com.aula.models.Pessoa;

@Named
@ApplicationScoped
public class ExibirDadosBean {

	private String nome;
	private String email;
	private String senha;
	private String sexo;
	private String cidade;
	private List<String> videoGames;
	private List<String> cidades;
	private List<Pessoa> pessoas;

	@PostConstruct
	public void init() {
		cidades = new ArrayList<String>();
		pessoas = new ArrayList<Pessoa>();
		videoGames = new ArrayList<String>();
		cidades.add("João Pessoa");
		cidades.add("Campina Grande");
		cidades.add("Recife");
		cidades.add("Natal");
		pessoas.add(new Pessoa("João", "joao@email.com", "João Pessoa"));
		pessoas.add(new Pessoa("Maria", "maria@email.com", "Recife"));
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public List<String> getVideoGames() {
		return videoGames;
	}

	public void setVideoGames(List<String> videoGames) {
		this.videoGames = videoGames;
	}

	public List<String> getCidades() {
		return cidades;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public void exibir() {
		System.out.println(nome);
		System.out.println(email);
		System.out.println(senha);
		System.out.println(cidade);
		System.out.println(sexo);
		System.out.println(videoGames);
	}

}
