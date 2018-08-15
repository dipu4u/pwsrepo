package com.mipa.core.store.dao;

import java.util.List;

import com.mipa.core.dao.AbstractDao;
import com.mipa.core.store.entity.StoreEntity;

public interface StoreDataDao extends AbstractDao<StoreEntity> {
	
	List<StoreEntity> getStoreList(final Integer offset, final Integer limit);
	
	List<StoreEntity> getDeletedStoreList(final Integer offset, final Integer limit);
	
}