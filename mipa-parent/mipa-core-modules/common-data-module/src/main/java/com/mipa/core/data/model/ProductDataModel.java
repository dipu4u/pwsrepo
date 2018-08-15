package com.mipa.core.data.model;

import java.time.OffsetDateTime;

import com.mipa.core.data.enums.ProductType;

public class ProductDataModel {

	private Integer productId;	
	private String productName;	
	private ProductType productType;	
	private String category;	
	private OffsetDateTime createdDate;	
	private boolean active;	
	private boolean deleted;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public OffsetDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(OffsetDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
}