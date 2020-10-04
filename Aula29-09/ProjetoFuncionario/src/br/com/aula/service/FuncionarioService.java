package br.com.aula.service;

import br.com.aula.dao.FuncionarioDAO;
import br.com.aula.exception.ServiceException;
import br.com.aula.model.Funcionario;

public class FuncionarioService {
	
	private FuncionarioDAO funcionarioDao;
	
	public FuncionarioService() {
		funcionarioDao = new FuncionarioDAO();
	}
	
	public void save(Funcionario funcionario) throws ServiceException {
		if(funcionario.getNome().length() < 4) {
			throw new ServiceException("O nome do Funcionario precisa ter mais de quatro caracteres");
		}else {
			funcionarioDao.save(funcionario);
		}
	}

}
