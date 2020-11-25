package br.com.aula.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.aula.dao.ContatoDao;
import br.com.aula.model.Contato;

@RequestScoped
public class ContatoService {
	
	@Inject
	private ContatoDao contatoDao;
	
	public void save(Contato contato) {
		contatoDao.save(contato);
	}
	
	public void update(Contato contato) {
		contatoDao.update(contato);
	}
	
	public void remove(long id) {
		contatoDao.remove(id);
	}
	
	public Contato findById(long id) {
		return contatoDao.findById(id);
	}
	
	public List<Contato> findAll(){
		return contatoDao.findAll();
	}
}
