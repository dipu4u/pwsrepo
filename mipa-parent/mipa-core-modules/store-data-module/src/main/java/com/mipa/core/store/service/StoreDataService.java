package com.mipa.core.store.service;

import java.util.List;

import com.mipa.core.data.model.AuthUserModel;
import com.mipa.core.data.model.StoreDataModel;

public interface StoreDataService {

	StoreDataModel createStore(StoreDataModel model, final AuthUserModel authUserModel);
	
	StoreDataModel getStore(final Integer storeId);
	
	StoreDataModel updateStore(StoreDataModel entity, final AuthUserModel authUserModel);
	
	boolean deleteStore(final Integer storeId);

	List<StoreDataModel> getStoreList(final Integer start, final Integer limit);
	
	List<StoreDataModel> getDeletedStoreList(final Integer start, final Integer limit);
}