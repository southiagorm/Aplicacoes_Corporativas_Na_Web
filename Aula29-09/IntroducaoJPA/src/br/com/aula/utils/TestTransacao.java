package br.com.aula.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.aula.entities.Livro;
import br.com.aula.exception.QuantidadeNegativaException;

public class TestTransacao {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto_exercicio");
		EntityManager em = emf.createEntityManager();
		
		Livro livro ;//= new Livro("Introdução a Go Lang", 300, 500, 5);
		
		//em.getTransaction().begin();
		livro = em.find(Livro.class, 10L);
		//em.getTransaction().commit();
		
		em.close();
		
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		try {
			livro.calcularQuantidade(1);
			em.merge(livro);
			em.getTransaction().commit();
			System.out.println("Alteração realizada com Sucesso!");
			System.out.println(livro.getQtde());
		}catch(QuantidadeNegativaException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
	}

}
