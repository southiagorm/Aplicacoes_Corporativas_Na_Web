package br.com.aula.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.aula.model.Funcionario;
import br.com.aula.model.Setor;
import br.com.aula.utils.JPAUtils;

public class FuncionarioDAO implements FuncionaroDAOIF, Serializable {
	
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	@Override
	public void save(Funcionario funcionario) {
		em = JPAUtils.getEntityManager();
		em.getTransaction().begin();
		em.persist(funcionario);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Funcionario funcionario) {
		em = JPAUtils.getEntityManager();
		em.getTransaction().begin();
		em.merge(funcionario);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remove(Funcionario funcionario) {
		em = JPAUtils.getEntityManager();
		em.getTransaction().begin();
		Funcionario f = em.find(Funcionario.class, funcionario.getId());
		em.remove(f);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Funcionario findById(Long id) {
		em = JPAUtils.getEntityManager();
		Funcionario f = em.find(Funcionario.class, id);
		em.close();
		return f;
	}

	@Override
	public List<Funcionario> findAll() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		em = JPAUtils.getEntityManager();
		String jpql = "FROM Funcionario";
		TypedQuery<Funcionario> query = em.createQuery(jpql, Funcionario.class);
		funcionarios = query.getResultList();
		em.close();
		return funcionarios;
	}
	
	public List<Funcionario> buscarComPaginacao(int first, int pageSize){
		EntityManager em = JPAUtils.getEntityManager();		
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		String jpql = "SELECT f FROM Funcionario f";
		TypedQuery<Funcionario> query = em.createQuery(jpql, Funcionario.class);
		query.setFirstResult(first);
		query.setMaxResults(pageSize);
		funcionarios = query.getResultList();
		em.close();
		return funcionarios;
	}
	
	public int quantidadeFuncionarios() {
		EntityManager em = JPAUtils.getEntityManager();	
		String jpql = "SELECT COUNT(f) FROM Funcionario f";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		int qtde = query.getSingleResult().intValue();
		em.close();
		return qtde;
	}

	@Override
	public Funcionario findByMatricula(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Funcionario findFuncionariosAndSetores(Funcionario funcionario){
		EntityManager em = JPAUtils.getEntityManager();
		Funcionario f = null;
		String jpql = "SELECT f FROM Funcionario f join fetch f.setores s where f.id = :id";
		TypedQuery<Funcionario> query = em.createQuery(jpql, Funcionario.class);
		query.setParameter("id", funcionario.getId());
		f = query.getSingleResult();
		em.close();
		return f;
	}

}
