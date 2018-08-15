package com.mipa.core.store.service.impl;


import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mipa.core.constants.CommonConstants;
import com.mipa.core.data.model.AuthUserModel;
import com.mipa.core.data.model.StoreDataModel;
import com.mipa.core.exception.InvalidInputException;
import com.mipa.core.exception.ObjectNotFoundException;
import com.mipa.core.store.dao.StoreDataDao;
import com.mipa.core.store.entity.StoreEntity;
import com.mipa.core.store.mapper.StoreModelMapper;
import com.mipa.core.store.service.StoreDataService;
import com.mipa.core.util.CommonUtility;

@Service
public class StoreDateServiceImpl implements StoreDataService {
	
	private static final Logger LOG = Logger.getLogger(StoreDateServiceImpl.class);

	@Autowired
	private StoreDataDao storeDataDao;
	
	@Autowired
	private StoreModelMapper modelMapper;
	
	@Override
	@Transactional
	public StoreDataModel createStore(StoreDataModel model, final AuthUserModel authUserModel) {
		StoreEntity entity = modelMapper.buildStoreEntity(model);
		entity.setCreatedDate(OffsetDateTime.now(CommonConstants.UTC_ZONEID));
		storeDataDao.save(entity);
		model.setStoreId(entity.getStoreId());
		LOG.debug("New Store " + model.getStoreName() + " created with ID: " + model.getStoreId());
		return model;
	}

	@Transactional
	@Override
	public StoreDataModel updateStore(StoreDataModel model, final AuthUserModel authUserModel) {
		StoreEntity entity = storeDataDao.getObjectById(model.getStoreId());
		if(Objects.isNull(entity))
			throw new ObjectNotFoundException("Store not found for update. ID: " + model.getStoreId());
		entity.setStoreName(model.getStoreName());
		entity.setStoreType(model.getStoreType());
		entity.setBranch(model.getBranch());
		entity.setAddress(model.getAddress());
		entity.setPincode(model.getPincode());
		entity.setCountryId(model.getCountryId());
		entity.setCountyId(model.getCountyId());
		entity.setCityId(model.getCityId());
		entity.setLatitude(model.getLatitude());
		entity.setLongitude(model.getLongitude());
		entity.setActive(model.isActive());
		entity.setDeleted(model.isDeleted());
		StoreEntity updatedEntity = storeDataDao.update(entity);
		return modelMapper.buildStoreDataModel(updatedEntity);
	}

	@Override
	public List<StoreDataModel> getStoreList(final Integer start, final Integer limit) {
		if(CommonUtility.validPaginationValues(start, limit)) {
			final List<StoreEntity> list = storeDataDao.getStoreList(start, limit);
			final List<StoreDataModel> modelList = new ArrayList<StoreDataModel>(list.size());
			list.forEach(entity -> modelList.add(modelMapper.buildStoreDataModel(entity)));
			return modelList;
		}
		throw new InvalidInputException("Pagination values are incorrect. Start " + start + " limit " + limit);
	}

	@Override
	public StoreDataModel getStore(Integer storeId) {
		StoreEntity entity = storeDataDao.getObjectById(storeId);
		if(Objects.isNull(entity))
			throw new ObjectNotFoundException("Store not found. ID: " + storeId);
		return modelMapper.buildStoreDataModel(entity);
	}

	@Override
	@Transactional
	public boolean deleteStore(Integer storeId) {
		StoreEntity entity = storeDataDao.getObjectById(storeId);
		if(Objects.isNull(entity))
			throw new ObjectNotFoundException("Store not found for delete. ID: " + storeId);
		entity.setDeleted(true);
		StoreEntity updated = storeDataDao.update(entity);
		return Objects.nonNull(updated);
	}
	
	@Override
	public List<StoreDataModel> getDeletedStoreList(final Integer start, final Integer limit) {
		if(CommonUtility.validPaginationValues(start, limit)) {
			final List<StoreEntity> list = storeDataDao.getDeletedStoreList(start, limit);
			final List<StoreDataModel> modelList = new ArrayList<StoreDataModel>(list.size());
			list.forEach(entity -> modelList.add(modelMapper.buildStoreDataModel(entity)));
			return modelList;
		}
		throw new InvalidInputException("Pagination values are incorrect. Start " + start + " limit " + limit);
	}

}