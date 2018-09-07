package com.mipa.osgi.core.db.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mipa.osgi.core.db.dao.ProviderDataActivityDao;
import com.mipa.osgi.core.db.entity.ProviderDataActivityEntity;

public class ProviderDataActivityDaoImpl extends AbstractDaoImpl<ProviderDataActivityEntity> 
		implements ProviderDataActivityDao {
	
	private static final String TABLE_NAME = "providerdataactivitymaster";

	public ProviderDataActivityDaoImpl() {}

	@Override
	public boolean save(ProviderDataActivityEntity entity) {
		boolean inserted = false;
		QueryRunner runner = new QueryRunner(getDataSource());		
		try {
			int status = runner.update("insert into " + TABLE_NAME + " (providerId, runDateTime, jobStatus) "
					+ "values (next value for providerdataactivitymaster_seq,?,?)", 
					entity.getProviderId(), entity.getRunDateTime(), entity.getJobStatus().name());
			inserted = status > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inserted;
	}
	
}