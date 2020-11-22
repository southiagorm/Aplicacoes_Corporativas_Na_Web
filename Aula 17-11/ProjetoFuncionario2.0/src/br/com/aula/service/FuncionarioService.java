package br.com.aula.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.aula.dao.FuncionarioDAO;
import br.com.aula.exception.ServiceException;
import br.com.aula.model.Funcionario;
import br.com.aula.trasaction.annotation.Transacional;

public class FuncionarioService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private FuncionarioDAO funcionarioDao;
	
	//em.getTransaction().begin();
	@Transacional
	public void save(Funcionario funcionario) throws ServiceException {
		if(funcionario.getNome().length() < 4) {
			throw new ServiceException("O nome do Funcionario precisa ter mais de quatro caracteres");
		}else {
			funcionarioDao.save(funcionario);
		}
	}
	//em.getTransaction().commit();

}
