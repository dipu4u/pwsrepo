package com.mipa.osgi.core.db.dao;

import javax.sql.DataSource;

import com.mipa.osgi.core.db.entity.ProviderDataActivityEntity;


public interface ProviderDataActivityDao {
	
	void setDataSource(DataSource dataSource);

	boolean save(ProviderDataActivityEntity entity);
	
}
