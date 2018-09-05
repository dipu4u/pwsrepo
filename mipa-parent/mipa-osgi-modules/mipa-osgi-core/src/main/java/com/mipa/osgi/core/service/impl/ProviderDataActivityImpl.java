package com.mipa.osgi.core.service.impl;

import java.time.OffsetDateTime;
import java.time.ZoneId;

import com.mipa.osgi.core.db.dao.ProviderDataActivityDao;
import com.mipa.osgi.core.db.entity.ProviderDataActivityEntity;
import com.mipa.osgi.core.service.ProviderDataActivityService;

public class ProviderDataActivityImpl implements ProviderDataActivityService {

	private ProviderDataActivityDao activityDao = null;
	
	@Override
	public Long createActivity(final Integer providerId) {
		ProviderDataActivityEntity entity = new ProviderDataActivityEntity();
		entity.setProviderId(providerId);
		OffsetDateTime time = OffsetDateTime.now(ZoneId.of("UTC"));
		entity.setRunDateTime(time);
		activityDao.save(entity);
		return entity.getSerialId();
	}

	@Override
	public void setProviderDataActivityDao(ProviderDataActivityDao dao) {
		activityDao = dao;
	}

}