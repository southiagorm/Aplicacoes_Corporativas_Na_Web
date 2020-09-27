package br.com.aula.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.aula.entities.Aluno;

public class ListaAlunos {
	
	private static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	public static void adicionarAluno(Aluno aluno) {
		if(aluno != null) {
			alunos.add(aluno);
		}
	}
	
	public static List<Aluno> listar(){
		return Collections.unmodifiableList(alunos);
	}

}
