package com.mipa.core.product.mapper;

import org.springframework.stereotype.Component;

import com.mipa.core.data.model.ProductDataModel;
import com.mipa.core.product.entity.ProductEntity;

@Component
public class ProductModelMapper {

	public ProductDataModel buildModel(ProductEntity entity) {
		ProductDataModel model = new ProductDataModel();
		model.setProductId(entity.getProductId());
		model.setProductName(entity.getProductName());
		model.setProductType(entity.getProductType());
		model.setCategory(entity.getCategory());
		model.setActive(entity.isActive());
		model.setDeleted(entity.isDeleted());		
		return model;
	}
	
	public ProductEntity buildEntity(ProductDataModel model) {
		ProductEntity entity = new ProductEntity();
		entity.setProductId(model.getProductId());
		entity.setProductName(model.getProductName());
		entity.setProductType(model.getProductType());
		entity.setCategory(model.getCategory());
		entity.setActive(model.isActive());
		entity.setDeleted(model.isDeleted());
		return entity;
	}
	
}