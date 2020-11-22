package br.com.aula.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.aula.model.Contato;

@Stateless
public class ContatoDao {
	
	@PersistenceContext(unitName = "projeto_contato")
	private EntityManager em;

	public void save(Contato contato) {
		em.persist(contato);
	}
	
	public void update(Contato contato) {
		em.merge(contato);
	}
	
	public void remove(Long id) {
		Contato contato = em.find(Contato.class, id);
		em.remove(contato);
	}
	
	public Contato findById(Long id) {
		return em.find(Contato.class, id);
	}
	
	public List<Contato> findAll(){
		return em.createQuery("FROM Contato", Contato.class).getResultList();
	}
}
