package br.com.aula.entities;

public class Aluno {

	private String nome;
	private float nota1, nota2;
	private float media;
	private String situacao;

	public Aluno() {

	}

	public Aluno(String nome, float nota1, float nota2, float media, String situacao) {
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.media = media;
		this.situacao = situacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getNota1() {
		return nota1;
	}

	public void setNota1(float nota1) {
		this.nota1 = nota1;
	}

	public float getNota2() {
		return nota2;
	}

	public void setNota2(float nota2) {
		this.nota2 = nota2;
	}

	public float getMedia() {
		return media;
	}

	public void setMedia(float media) {
		this.media = media;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public void calcularMedia() {
		this.media = (this.nota1 + this.nota2) / 2;
	}

	public void verificarSituacao() {
		if (this.media >= 7) {
			this.situacao = "Aprovado";
		} else if (this.media >= 4) {
			this.situacao = "Recuperação";
		} else {
			this.situacao = "Reprovado";
		}
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", media=" + media + ", situacao=" + situacao + "]";
	}

}
