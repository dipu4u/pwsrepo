package com.mipa.core.product.dao;

import java.util.List;

import com.mipa.core.dao.AbstractDao;
import com.mipa.core.product.entity.ProductEntity;

public interface ProductDataDao extends AbstractDao<ProductEntity> {

	List<ProductEntity> getProductList(final Integer offset, final Integer limit);
	
	List<ProductEntity> getDeletedProductList(final Integer offset, final Integer limit);

}