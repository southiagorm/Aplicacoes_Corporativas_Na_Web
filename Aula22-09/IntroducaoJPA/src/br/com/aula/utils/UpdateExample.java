package br.com.aula.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.aula.entities.Livro;

public class UpdateExample {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto_exercicio");
		EntityManager em = emf.createEntityManager();
		
		Livro livro = em.find(Livro.class, 3L);
		
		em.getTransaction().begin();
		livro.setPreco(450);
		livro.setTitulo("Introdução a SQL Lite");
		em.getTransaction().commit();
		
	}

}
