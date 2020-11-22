package br.com.aula.service;

import java.io.Serializable;

import br.com.aula.dao.SetorDao;
import br.com.aula.exception.ServiceException;
import br.com.aula.model.Setor;

public class SetorService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private SetorDao setorDao;
	
	public SetorService() {
		setorDao = new SetorDao();
	}
	
	public void save(Setor setor) throws ServiceException {
		if(setor.getNome().length() < 4) {
			throw new ServiceException("O nome do Setor precisa ter mais de quatro caracteres");
		}else {
			setorDao.save(setor);
		}
	}

}
