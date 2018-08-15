package com.mipa.core.store.mapper;

import org.springframework.stereotype.Component;

import com.mipa.core.data.model.StoreDataModel;
import com.mipa.core.store.entity.StoreEntity;

@Component
public class StoreModelMapper {

	public StoreEntity buildStoreEntity(final StoreDataModel model) {
		StoreEntity entity = new StoreEntity();
		entity.setStoreId(model.getStoreId());
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
		return entity;
	}
	
	public StoreDataModel buildStoreDataModel(final StoreEntity entity) {
		StoreDataModel model = new StoreDataModel();
		model.setStoreId(entity.getStoreId());
		model.setStoreName(entity.getStoreName());
		model.setStoreType(entity.getStoreType());
		model.setBranch(entity.getBranch());
		model.setAddress(entity.getAddress());
		model.setPincode(entity.getPincode());
		model.setCountryId(entity.getCountryId());
		model.setCountyId(entity.getCountyId());
		model.setCityId(entity.getCityId());
		model.setLatitude(entity.getLatitude());
		model.setLongitude(entity.getLongitude());
		model.setActive(entity.isActive());
		model.setDeleted(entity.isDeleted());
		model.setCreatedDate(entity.getCreatedDate());
		return model;
	}
	
}