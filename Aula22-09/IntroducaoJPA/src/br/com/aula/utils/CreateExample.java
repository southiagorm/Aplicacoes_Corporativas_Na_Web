package br.com.aula.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.aula.entities.Livro;

public class CreateExample {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto_exercicio");
		EntityManager em = emf.createEntityManager();
		
		Livro livro = new Livro("Introdução a Sql", 450, 300, 5);
		
		em.getTransaction().begin();
		em.persist(livro);
		em.getTransaction().commit();
		
	}

}
