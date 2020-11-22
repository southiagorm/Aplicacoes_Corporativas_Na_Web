package br.com.aula.service;

import java.io.Serializable;

import br.com.aula.dao.FuncionarioDAO;
import br.com.aula.dao.TelefoneDAO;
import br.com.aula.exception.ServiceException;
import br.com.aula.model.Funcionario;
import br.com.aula.model.Telefone;

public class TelefoneService implements Serializable{

	private static final long serialVersionUID = 1L;
	private TelefoneDAO telefoneDao;
	
	public TelefoneService() {
		telefoneDao = new TelefoneDAO();
	}
	
	public void save(Telefone telefone) throws ServiceException {
		if(telefone.getCodigoArea() > 10 && telefone.getCodigoArea() <= 99) {
			telefoneDao.save(telefone);
		}else if(telefone.getTipoTelefone() == null){ 
			throw new ServiceException("Selecione um Telefone");
		}else if(telefone.getFuncionario() == null){ 
			throw new ServiceException("Selecione um Funcionário");
		}else{
			throw new ServiceException("O código de área precisa ser maior que 10 e menor que 100");
		}
	}
}
