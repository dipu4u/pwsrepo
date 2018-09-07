package com.mipa.osgi.core.db.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mipa.osgi.core.db.dao.ProviderDataDao;
import com.mipa.osgi.core.db.entity.ProviderDataEntity;

public class ProviderDataDaoImpl extends AbstractDaoImpl<ProviderDataEntity> 
		implements ProviderDataDao {
	
	private static final String TABLE_NAME = "providerdatamaster";

	public ProviderDataDaoImpl() {}

	@Override
	public boolean save(ProviderDataEntity entity) {
		boolean inserted = false;
		QueryRunner runner = new QueryRunner(getDataSource());		
		try {
			int status = runner.update("insert into " + TABLE_NAME + " (providerName, countryId, pincodes, active) "
					+ "values (next value for providerdatamaster_seq,?,?,?)", 
					entity.getProviderName(), entity.getCountryId(), entity.getPincodes(), entity.getActive());
			inserted = status > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inserted;
	}

	@Override
	public ProviderDataEntity getObjectById(final Integer providerId) {
		ProviderDataEntity entity = null;
		ResultSetHandler<ProviderDataEntity> resultHandler = 
				new BeanHandler<ProviderDataEntity>(ProviderDataEntity.class);
		QueryRunner runner = new QueryRunner(getDataSource());
		try {
			entity = runner.query("select * from " + TABLE_NAME + " where providerId=?", resultHandler, providerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}

}