package com.mipa.osgi.core.service;

import com.mipa.osgi.core.db.dao.ProviderDataActivityDao;


public interface ProviderDataActivityService {

	void setProviderDataActivityDao(ProviderDataActivityDao dao);
	
	Long createActivity(final Integer providerId);

}