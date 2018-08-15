package com.mipa.core.store.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mipa.core.dao.AbstractDaoImpl;
import com.mipa.core.store.constant.StoreConstants;
import com.mipa.core.store.dao.StoreDataDao;
import com.mipa.core.store.entity.StoreEntity;

@Repository
public class StoreDataDaoImpl extends AbstractDaoImpl<StoreEntity> implements StoreDataDao {

	public StoreDataDaoImpl() {
		super(StoreEntity.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StoreEntity> getStoreList(Integer offset, Integer limit) {
		Query query = getEntityManager().createNamedQuery(StoreConstants.QUERY_STORE);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<StoreEntity> getDeletedStoreList(Integer offset, Integer limit) {
		Query query = getEntityManager().createNamedQuery(StoreConstants.QUERY_DELETED_STORE);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return query.getResultList();
	}
}