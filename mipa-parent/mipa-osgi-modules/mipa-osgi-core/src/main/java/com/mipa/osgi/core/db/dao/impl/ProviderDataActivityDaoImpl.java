package com.mipa.osgi.core.db.dao.impl;

import javax.sql.DataSource;

import com.mipa.osgi.core.db.dao.ProviderDataActivityDao;
import com.mipa.osgi.core.db.entity.ProviderDataActivityEntity;

public class ProviderDataActivityDaoImpl implements ProviderDataActivityDao {

	private DataSource dataSource;
	
	public ProviderDataActivityDaoImpl() {
	}

	@Override
	public boolean save(ProviderDataActivityEntity entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}