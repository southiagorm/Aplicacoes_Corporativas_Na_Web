package br.com.aula.beans;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.aula.entities.Aluno;
import br.com.aula.utils.ListaAlunos;

@Named
@RequestScoped
public class ListarBean {

	private List<Aluno> alunos;
	
	@PostConstruct
	public void init() {
		alunos = ListaAlunos.listar();
	}

	public List<Aluno> getAlunos() {
		return Collections.unmodifiableList(alunos);
	}
	
	
}
