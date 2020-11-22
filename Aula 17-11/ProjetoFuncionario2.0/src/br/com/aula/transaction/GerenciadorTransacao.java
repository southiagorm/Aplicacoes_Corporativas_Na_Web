package br.com.aula.transaction;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import br.com.aula.trasaction.annotation.Transacional;

@Interceptor
@Transacional
public class GerenciadorTransacao {
	
	@Inject
	private EntityManager em;
	
	@AroundInvoke
	public Object interceptAction(InvocationContext context) {
		
		em.getTransaction().begin();
		
		try {
			Object resultado = context.proceed();
			em.getTransaction().commit();
			
			return resultado;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			em.getTransaction().rollback();
			
			throw new RuntimeException(e);
		}
	}

}
