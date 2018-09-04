package com.mipa.osgi.core.db.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mipa.osgi.core.db.dao.AbstractDao;


public abstract class AbstractDaoImpl<T> implements AbstractDao<T> {
	
	private static final Logger LOG = Logger.getLogger(AbstractDaoImpl.class);

	private Class<T> entityClass;
	
	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	private EntityManager em;

	protected AbstractDaoImpl(final Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public T save(T object) {
		em.persist(object);
		return object;
	}

	@Override
	public T getObjectById(Serializable id) {
		T obj = null;
		try {
			obj = em.find(entityClass, id);
		}catch(EntityNotFoundException enf) {
			LOG.error(entityClass.getSimpleName() + " with ID: " + id + ", not found in DB", enf);
		}
		return obj;
	}

	@Override
	public T update(T object) {
		return em.merge(object);
	}

	@Override
	public boolean delete(Serializable id) {
		return delete(getObjectById(id));
	}

	@Override
	public boolean delete(T object) {
		boolean status = false;
		try {
			em.remove(object);
			status = true;
		} catch(Exception e) {
			LOG.error(e);
		}
		return status;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAllRecords() {
		Query query = em.createQuery("select obj from " + entityClass.getSimpleName() + " obj");
		return query.getResultList();
	}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}

}