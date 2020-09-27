package br.com.aula.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.aula.entities.Aluno;
import br.com.aula.utils.ListaAlunos;

@Named
@RequestScoped
public class CadastroBean {

	private Aluno aluno;

	@PostConstruct
	public void init() {
		aluno = new Aluno();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public String cadastrarAluno() {
		aluno.calcularMedia();
		aluno.verificarSituacao();
		
		ListaAlunos.adicionarAluno(aluno);
		
		System.out.println(ListaAlunos.listar());
		
		return "listar?faces-redirect=true";
	}

}
