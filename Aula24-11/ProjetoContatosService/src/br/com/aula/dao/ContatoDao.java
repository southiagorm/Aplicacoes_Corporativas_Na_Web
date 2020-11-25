package br.com.aula.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.aula.enums.ErrorCode;
import br.com.aula.exception.DaoException;
import br.com.aula.model.Contato;

@Stateless
public class ContatoDao {
	
	@PersistenceContext(unitName = "projeto_contato")
	private EntityManager em;

	public void save(Contato contato) {
		try {
			em.persist(contato);
		}catch(RuntimeException e) {
			throw new DaoException("Erro ao tentar salvar um contato no banco de dados: " + e.getMessage(), 
					ErrorCode.SERVER_ERROR.getCode());
		}
	}
	
	public void update(Contato contato) {
		
		if(contato.getId() <= 0) {
			throw new DaoException("O id enviado precisa ser maior que zero", ErrorCode.BAD_REQUEST.getCode());
		}
		
		try {
			Contato contatoTemp = em.find(Contato.class, contato.getId());
			contatoTemp.setNome(contato.getNome());
			contatoTemp.setEmail(contato.getEmail());
			contatoTemp.setTelefone(contato.getTelefone());
			em.merge(contato);
		}catch(NullPointerException e) {
			throw new DaoException("O contato informado não existe: " + e.getMessage(), ErrorCode.NOT_FOUND.getCode());
		}catch (RuntimeException e) {
			throw new DaoException("Erro ao tentar alterar um contato no banco de dados: " + e.getMessage(), 
					ErrorCode.SERVER_ERROR.getCode());
		}
	}
	
	public void remove(Long id) {
		
		if(id <= 0) {
			throw new DaoException("O id enviado precisa ser maior que zero", ErrorCode.BAD_REQUEST.getCode());
		}
		
		try {
			Contato contato = em.find(Contato.class, id);
			em.remove(contato);
		}catch(IllegalArgumentException e) {
			throw new DaoException("O contato informado não existe: " + e.getMessage(), ErrorCode.NOT_FOUND.getCode());
		}catch (RuntimeException e) {
			throw new DaoException("Erro ao tentar alterar um contato no banco de dados: " + e.getMessage(), 
					ErrorCode.SERVER_ERROR.getCode());
		}
	}
	
	public Contato findById(Long id) {
		Contato contato = null;
		
		if(id <= 0) {
			throw new DaoException("O id enviado precisa ser maior que zero", ErrorCode.BAD_REQUEST.getCode());
		}
		
		try {
			contato = em.find(Contato.class, id);
		}catch (RuntimeException e) {
			throw new DaoException("Erro ao tentar buscar um contato no banco de dados: " + e.getMessage(), 
					ErrorCode.SERVER_ERROR.getCode());
		}
		
		if(contato == null) {
			throw new DaoException("O contato informado não existe ", ErrorCode.NOT_FOUND.getCode());
		}
		
		return contato;
	}
	
	public List<Contato> findAll(){
		try {
			return em.createQuery("FROM Contato", Contato.class).getResultList();
		}catch(RuntimeException e) {
			throw new DaoException("Erro ao tentar buscar todos os contatos no banco de dados: " + e.getMessage(), 
					ErrorCode.SERVER_ERROR.getCode());
		}
	}
}
