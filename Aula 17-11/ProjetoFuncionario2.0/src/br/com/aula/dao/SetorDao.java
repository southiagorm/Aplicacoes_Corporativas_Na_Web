package br.com.aula.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.aula.model.Setor;
import br.com.aula.utils.JPAUtils;

public class SetorDao implements GenericDAOIF<Setor>, Serializable{

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;

	@Override
	public void save(Setor setor) {
		em = JPAUtils.getEntityManager();
		em.getTransaction().begin();
		em.persist(setor);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Setor setor) {
		em = JPAUtils.getEntityManager();
		em.getTransaction().begin();
		em.merge(setor);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remove(Setor setor) {
		em = JPAUtils.getEntityManager();
		em.getTransaction().begin();
		Setor s = em.find(Setor.class, setor.getId());
		em.remove(s);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Setor findById(Long id) {
		em = JPAUtils.getEntityManager();
		Setor s = em.find(Setor.class, id);
		em.close();
		return s;
	}

	@Override
	public List<Setor> findAll() {
		List<Setor> setores = new ArrayList<Setor>();
		em = JPAUtils.getEntityManager();
		String jpql = "FROM Setor";
		System.out.println(em);
		TypedQuery<Setor> query = em.createQuery(jpql, Setor.class);
		setores = query.getResultList();
		em.close();
		return setores;
	}
}
