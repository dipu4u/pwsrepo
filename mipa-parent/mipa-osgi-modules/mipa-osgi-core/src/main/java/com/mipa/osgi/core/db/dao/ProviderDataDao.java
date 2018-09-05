package com.mipa.osgi.core.db.dao;

import javax.sql.DataSource;

import com.mipa.osgi.core.db.entity.ProviderDataEntity;

public interface ProviderDataDao {
	
	void setDataSource(DataSource dataSource);

	ProviderDataEntity getObjectById(final Integer providerId);
	
}
