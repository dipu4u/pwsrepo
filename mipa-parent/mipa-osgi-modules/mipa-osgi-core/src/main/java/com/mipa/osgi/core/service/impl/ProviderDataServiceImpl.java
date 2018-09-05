package com.mipa.osgi.core.service.impl;

import com.mipa.osgi.core.db.dao.ProviderDataDao;
import com.mipa.osgi.core.db.entity.ProviderDataEntity;
import com.mipa.osgi.core.service.ProviderDataService;

public class ProviderDataServiceImpl implements ProviderDataService {

	private ProviderDataDao providerDataDao;
	
	@Override
	public ProviderDataEntity getProvider(final Integer providerId) {
		return providerDataDao.getObjectById(providerId);
	}

	@Override
	public void setProviderDataDao(ProviderDataDao providerDataDao) {
		this.providerDataDao = providerDataDao;
	}
	
}