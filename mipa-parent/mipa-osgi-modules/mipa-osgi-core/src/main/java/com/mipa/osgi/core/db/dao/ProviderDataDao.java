package com.mipa.osgi.core.db.dao;

import com.mipa.osgi.core.db.entity.ProviderDataEntity;

public interface ProviderDataDao extends AbstractDao<ProviderDataEntity> {
	
	ProviderDataEntity getObjectById(final Integer providerId);
	
}