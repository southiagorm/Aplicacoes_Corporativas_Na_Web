package br.com.aula.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.aula.entities.Livro;

public class RetrieveExample {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto_exercicio");
		EntityManager em = emf.createEntityManager();
		
		Livro livro = em.find(Livro.class, 1L);
		
		if(livro != null) {
			System.out.println("Título: " + livro.getTitulo());
			System.out.println("Preço: " + livro.getPreco());
		}else {
			System.out.println("Livro não encontrado");
		}
		
	}

}
