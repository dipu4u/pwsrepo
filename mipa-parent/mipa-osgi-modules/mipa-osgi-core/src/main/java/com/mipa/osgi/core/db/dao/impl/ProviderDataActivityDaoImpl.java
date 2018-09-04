package com.mipa.osgi.core.db.dao.impl;

import com.mipa.osgi.core.db.dao.ProviderDataActivityDao;
import com.mipa.osgi.core.db.entity.ProviderDataActivityEntity;

public class ProviderDataActivityDaoImpl extends AbstractDaoImpl<ProviderDataActivityEntity> implements ProviderDataActivityDao {

	public ProviderDataActivityDaoImpl() {
		super(ProviderDataActivityEntity.class);
	}
	
}