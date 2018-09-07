package com.mipa.osgi.core.db.dao.impl;

import javax.sql.DataSource;

import com.mipa.osgi.core.db.dao.AbstractDao;

public abstract class AbstractDaoImpl<T> implements AbstractDao<T> {
	
	private DataSource dataSource;

	protected AbstractDaoImpl() {}

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
	}

	@Override
	public DataSource getDataSource() {
		return dataSource;
	}
	
}