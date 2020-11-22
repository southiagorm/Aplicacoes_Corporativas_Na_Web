package br.com.aula.utils;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto_empresa");
	
	@Produces
	@RequestScoped
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void close (@Disposes EntityManager em) {
		if(em.isOpen()) {
			em.close();
		}
	}

}
