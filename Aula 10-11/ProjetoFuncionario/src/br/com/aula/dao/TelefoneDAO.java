package br.com.aula.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.aula.model.Telefone;
import br.com.aula.utils.JPAUtils;

public class TelefoneDAO implements TelefoneDAOIF, Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;

	@Override
	public void save(Telefone telefone) {
		em = JPAUtils.getEntityManager();
		em.getTransaction().begin();
		em.persist(telefone);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Telefone telefone) {
		em = JPAUtils.getEntityManager();
		em.getTransaction().begin();
		em.merge(telefone);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void remove(Telefone telefone) {
		em = JPAUtils.getEntityManager();
		em.getTransaction().begin();
		Telefone t = em.find(Telefone.class, telefone.getId());
		em.remove(t);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public Telefone findById(Long id) {
		em = JPAUtils.getEntityManager();
		Telefone t = em.find(Telefone.class, id);
		em.close();
		return t;
	}

	@Override
	public List<Telefone> findAll() {
		List<Telefone> telefones = new ArrayList<Telefone>();
		em = JPAUtils.getEntityManager();
		String jpql = "FROM Telefone";
		TypedQuery<Telefone> query = em.createQuery(jpql, Telefone.class);
		telefones = query.getResultList();
		em.close();
		return telefones;
	}

}
