package br.com.aula.dao;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.aula.model.Funcionario;

public class LazyFuncionarioDatabase extends LazyDataModel<Funcionario>{
	
	private static final long serialVersionUID = 1L;
	
	private FuncionarioDAO funcionarioDao;
	
	public LazyFuncionarioDatabase(FuncionarioDAO fDao) {
		this.funcionarioDao = fDao;
	}
	
	@Override
	public List<Funcionario> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		
		System.out.println("First: " + first);
		System.out.println("Page Size: " + pageSize);
		
		List<Funcionario> funcionarios = funcionarioDao.buscarComPaginacao(first, pageSize);
		this.setRowCount(funcionarioDao.quantidadeFuncionarios());
		
		return funcionarios;
	}

}
