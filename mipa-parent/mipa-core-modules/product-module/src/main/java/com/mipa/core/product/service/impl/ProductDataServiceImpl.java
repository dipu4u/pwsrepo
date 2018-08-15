package com.mipa.core.product.service.impl;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mipa.core.constants.CommonConstants;
import com.mipa.core.data.model.ProductDataModel;
import com.mipa.core.exception.InvalidInputException;
import com.mipa.core.exception.ObjectNotFoundException;
import com.mipa.core.product.dao.ProductDataDao;
import com.mipa.core.product.entity.ProductEntity;
import com.mipa.core.product.mapper.ProductModelMapper;
import com.mipa.core.product.service.ProductDataService;
import com.mipa.core.util.CommonUtility;

@Service
public class ProductDataServiceImpl implements ProductDataService {

	@Autowired
	private ProductDataDao productDataDao;
	
	@Autowired
	private ProductModelMapper mapper;
	
	@Override
	@Transactional
	public ProductDataModel createProduct(ProductDataModel model) {
		ProductEntity entity = mapper.buildEntity(model);
		entity.setCreatedDate(OffsetDateTime.now(CommonConstants.UTC_ZONEID));
		productDataDao.save(entity);
		model.setProductId(entity.getProductId());
		model.setCreatedDate(entity.getCreatedDate());
		return model;
	}

	@Override
	@Transactional
	public ProductDataModel updateProduct(ProductDataModel model) {
		ProductEntity entity = productDataDao.getObjectById(model.getProductId());
		if(Objects.isNull(entity)) {
			throw new ObjectNotFoundException("Product not found for update. ID: " + model.getProductId());
		}
		entity.setProductName(model.getProductName());
		entity.setProductType(model.getProductType());
		entity.setCategory(model.getCategory());
		entity.setActive(model.isActive());
		entity.setDeleted(model.isDeleted());		
		productDataDao.update(entity);
		return model;
	}

	@Override
	@Transactional
	public boolean deleteProduct(Integer productId) {
		ProductEntity entity = productDataDao.getObjectById(productId);
		if(Objects.isNull(entity)) {
			throw new ObjectNotFoundException("Product not found for delete. ID: " + productId);
		}
		entity.setDeleted(true);
		productDataDao.update(entity);
		return true;
	}

	@Override
	public List<ProductDataModel> getProducts(final Integer start, final Integer limit) {
		if(CommonUtility.validPaginationValues(start, limit)) {
			final List<ProductEntity> list = productDataDao.getProductList(start, limit);
			final List<ProductDataModel> productList = new ArrayList<ProductDataModel>(list.size());
			list.forEach(product -> productList.add(mapper.buildModel(product)));
			return productList;
		}
		throw new InvalidInputException("Pagination values are incorrect. Start " + start + " limit " + limit);
	}
	
	@Override
	public List<ProductDataModel> getDeletedProducts(final Integer start, final Integer limit) {
		if(CommonUtility.validPaginationValues(start, limit)) {
			final List<ProductEntity> list = productDataDao.getDeletedProductList(start, limit);
			final List<ProductDataModel> productList = new ArrayList<ProductDataModel>(list.size());
			list.forEach(product -> productList.add(mapper.buildModel(product)));
			return productList;
		}
		throw new InvalidInputException("Pagination values are incorrect. Start " + start + " limit " + limit);
	}

	@Override
	public ProductDataModel getProduct(Integer productId) {
		ProductEntity entity = productDataDao.getObjectById(productId);
		if(Objects.isNull(entity)) {
			throw new ObjectNotFoundException("Product not found. ID: " + productId);
		}
		return mapper.buildModel(entity);
	}

}