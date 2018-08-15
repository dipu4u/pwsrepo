package com.mipa.core.product.entity;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.mipa.core.data.enums.ProductType;

@Entity
@Table(name="productmaster")
@NamedQueries({
	@NamedQuery(name="query.products", 
		query="select obj from ProductEntity obj where obj.deleted=false order by obj.productName asc"),
	@NamedQuery(name="query.deleted.products", 
		query="select obj from ProductEntity obj where obj.deleted=true order by obj.productName asc")
})
public class ProductEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_table_seq")
	@SequenceGenerator(name="product_table_seq", sequenceName="product_master_seq", initialValue=1)
	@Column(name="productId", updatable=false, nullable=false)
	private Integer productId;
	
	@Column(name="productName")
	private String productName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="productType")
	private ProductType productType;
	
	@Column(name="category")
	private String category;
	
	@Column(name="createdDate")
	private OffsetDateTime createdDate;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="deleted")
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