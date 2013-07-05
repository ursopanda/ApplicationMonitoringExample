package domain.base;

import java.io.Serializable;
import java.util.List;

import domain.UserEntity;

public interface GenericDAO<T, ID extends Serializable> {
	
	T save(T entity);
	T update(T entity);
	void delete(T entity);
	
	T findById(ID id);
	List<T> findAll();
	
	void flush();
	UserEntity getUserByUserName(String username);
	
}