package br.com.aula.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.aula.entities.Livro;

public class TestJPQL {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto_exercicio");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "SELECT l FROM Livro l";
		TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
		
		List<Livro> livros = query.getResultList(); 
		
		System.out.println(livros);
		
	}

}
