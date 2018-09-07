package com.mipa.osgi.core.db.dao;

import javax.sql.DataSource;

public interface AbstractDao<T> {

	boolean save(T object);
	
	void setDataSource(DataSource ds);
	
	DataSource getDataSource();

}