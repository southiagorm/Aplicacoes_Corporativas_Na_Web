package br.com.aula.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CalcularMediaBean {

	private String nome;
	private float nota1, nota2, media;
	private String situacao;

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

	public String getSituacao() {
		return situacao;
	}
	
	public void calcularMedia() {
		media = (nota1+nota2)/2;
		if(media >= 7) {
			situacao = "Aprovado";
		}else if(media >= 4) {
			situacao = "Recuperação";
		}else {
			situacao = "Reprovado";
		}
	}

}
