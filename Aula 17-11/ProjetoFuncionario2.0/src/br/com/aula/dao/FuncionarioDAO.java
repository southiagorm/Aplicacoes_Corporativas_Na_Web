package br.com.aula.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.aula.model.Funcionario;
import br.com.aula.model.Setor;
import br.com.aula.utils.JPAUtils;

public class FuncionarioDAO implements FuncionaroDAOIF, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;

	@Override
	public void save(Funcionario funcionario) {
		em.persist(funcionario);
	}

	@Override
	public void update(Funcionario funcionario) {
		em.merge(funcionario);
	}

	@Override
	public void remove(Funcionario funcionario) {
		Funcionario f = em.find(Funcionario.class, funcionario.getId());
		em.remove(f);
	}

	@Override
	public Funcionario findById(Long id) {
		Funcionario f = em.find(Funcionario.class, id);
		return f;
	}

	@Override
	public List<Funcionario> findAll() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		String jpql = "FROM Funcionario";
		TypedQuery<Funcionario> query = em.createQuery(jpql, Funcionario.class);
		funcionarios = query.getResultList();
		return funcionarios;
	}
	
	public List<Funcionario> buscarComPaginacao(int first, int pageSize){
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		String jpql = "SELECT f FROM Funcionario f";
		TypedQuery<Funcionario> query = em.createQuery(jpql, Funcionario.class);
		query.setFirstResult(first);
		query.setMaxResults(pageSize);
		funcionarios = query.getResultList();
		return funcionarios;
	}
	
	public int quantidadeFuncionarios() {
		String jpql = "SELECT COUNT(f) FROM Funcionario f";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		int qtde = query.getSingleResult().intValue();
		return qtde;
	}

	@Override
	public Funcionario findByMatricula(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Funcionario findFuncionariosAndSetores(Funcionario funcionario){
		Funcionario f = null;
		String jpql = "SELECT f FROM Funcionario f join fetch f.setores s where f.id = :id";
		TypedQuery<Funcionario> query = em.createQuery(jpql, Funcionario.class);
		query.setParameter("id", funcionario.getId());
		f = query.getSingleResult();
		return f;
	}

}
