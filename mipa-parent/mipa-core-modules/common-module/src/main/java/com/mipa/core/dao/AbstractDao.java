package com.mipa.core.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public interface AbstractDao<T> {

	T save(T object);
	
	T getObjectById(Serializable id);
	
	T update(T object);
	
	boolean delete(Serializable id);
	
	boolean delete(T object);
	
	List<T> getAllRecords();
	
	EntityManager getEntityManager();
	
}