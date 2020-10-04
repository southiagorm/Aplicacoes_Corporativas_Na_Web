package br.com.aula.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.aula.model.Funcionario;
import br.com.aula.utils.JPAUtils;

public class FuncionarioDAO implements FuncionaroDAOIF {
	
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
	public void update(Funcionario object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Funcionario object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Funcionario findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionario findByMatricula(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

}
