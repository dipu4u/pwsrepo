package com.mipa.core.product.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mipa.core.dao.AbstractDaoImpl;
import com.mipa.core.product.constant.ProductConstant;
import com.mipa.core.product.dao.ProductDataDao;
import com.mipa.core.product.entity.ProductEntity;

@Repository
public class ProductDataDaoImpl extends AbstractDaoImpl<ProductEntity> implements ProductDataDao {

	public ProductDataDaoImpl() {
		super(ProductEntity.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductEntity> getProductList(final Integer offset, final Integer limit) {
		Query query = getEntityManager().createNamedQuery(ProductConstant.QUERY_PRODUCTS);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductEntity> getDeletedProductList(final Integer offset, final Integer limit) {
		Query query = getEntityManager().createNamedQuery(ProductConstant.QUERY_DELETED_PRODUCTS);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return query.getResultList();
	}

}