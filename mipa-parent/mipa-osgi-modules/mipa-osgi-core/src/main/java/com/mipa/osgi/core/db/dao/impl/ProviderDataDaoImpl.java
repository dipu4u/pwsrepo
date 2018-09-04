package com.mipa.osgi.core.db.dao.impl;

import com.mipa.osgi.core.db.dao.ProviderDataDao;
import com.mipa.osgi.core.db.entity.ProviderDataEntity;

public class ProviderDataDaoImpl extends AbstractDaoImpl<ProviderDataEntity> implements ProviderDataDao {

	public ProviderDataDaoImpl() {
		super(ProviderDataEntity.class);
	}
	
}