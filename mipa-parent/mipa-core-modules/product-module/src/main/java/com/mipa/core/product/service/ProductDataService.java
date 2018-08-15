package com.mipa.core.product.service;

import java.util.List;

import com.mipa.core.data.model.ProductDataModel;

public interface ProductDataService {
	
	ProductDataModel createProduct(ProductDataModel model);
	
	ProductDataModel updateProduct(ProductDataModel model);
	
	boolean deleteProduct(final Integer productId);
	
	ProductDataModel getProduct(final Integer productId);
	
	List<ProductDataModel> getProducts(final Integer start, final Integer limit);
	
	List<ProductDataModel> getDeletedProducts(final Integer start, final Integer limit);
	
}