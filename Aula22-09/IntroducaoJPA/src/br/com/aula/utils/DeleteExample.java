package br.com.aula.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.aula.entities.Livro;

public class DeleteExample {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto_exercicio");
		EntityManager em = emf.createEntityManager();
		
		Livro livro = em.find(Livro.class, 1L);
		
		em.getTransaction().begin();
		em.remove(livro);
		em.getTransaction().commit();
		
		System.out.println("Removido com Sucesso!");
	}

}
