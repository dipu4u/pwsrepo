package com.mipa.osgi.core.db.dao.impl;

import javax.sql.DataSource;

import com.mipa.osgi.core.db.dao.ProviderDataDao;
import com.mipa.osgi.core.db.entity.ProviderDataEntity;

public class ProviderDataDaoImpl implements ProviderDataDao {

	private DataSource dataSource;
	
	public ProviderDataDaoImpl() {
	}

	@Override
	public ProviderDataEntity getObjectById(Integer providerId) {
		// TODO Auto-generated method stub
		return null;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}