package br.com.aula.dao;

import java.util.List;

public interface GenericDAOIF <T> {
	
	void save(T object);
	void update(T object);
	void remove(T object);
	T findById(Long id);
	List<T> findAll();
}
