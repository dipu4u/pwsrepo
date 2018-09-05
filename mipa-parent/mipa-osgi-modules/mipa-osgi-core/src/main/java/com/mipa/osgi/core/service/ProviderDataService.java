package com.mipa.osgi.core.service;

import com.mipa.osgi.core.db.dao.ProviderDataDao;
import com.mipa.osgi.core.db.entity.ProviderDataEntity;

public interface ProviderDataService {
	
	void setProviderDataDao(ProviderDataDao dao);
	
	ProviderDataEntity getProvider(final Integer providerId);
	
}