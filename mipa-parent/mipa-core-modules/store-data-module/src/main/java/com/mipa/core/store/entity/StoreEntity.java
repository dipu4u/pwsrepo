package com.mipa.core.store.entity;

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

import com.mipa.core.data.enums.StoreType;

@NamedQueries({
	@NamedQuery(name="query.stores", 
		query="select obj from StoreEntity obj where obj.deleted=false order by obj.storeName asc"),
	@NamedQuery(name="query.deleted.stores", 
		query="select obj from StoreEntity obj where obj.deleted=true order by obj.storeName asc")
})
@Entity
@Table(name="storemaster")
public class StoreEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="store_table_seq")
	@SequenceGenerator(name="store_table_seq", sequenceName="store_master_seq", initialValue=1)
	@Column(name="storeId", updatable=false, nullable=false)
	private Integer storeId;
	
	@Column(name="storeName")
	private String storeName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="storeType")
	private StoreType storeType;
	
	@Column(name="countryId")
	private Short countryId;
	
	@Column(name="countyId")
	private Integer countyId;
	
	@Column(name="cityId")
	private Integer cityId;

	@Column(name="branch")
	private String branch;
	
	@Column(name="address")
	private String address;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="latitude")
	private String latitude;
	
	@Column(name="longitude")
	private String longitude;
	
	@Column(name="createdDate")
	private OffsetDateTime createdDate;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="deleted")
	private boolean deleted;

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public StoreType getStoreType() {
		return storeType;
	}

	public void setStoreType(StoreType storeType) {
		this.storeType = storeType;
	}

	public Short getCountryId() {
		return countryId;
	}

	public void setCountryId(Short countryId) {
		this.countryId = countryId;
	}

	public Integer getCountyId() {
		return countyId;
	}

	public void setCountyId(Integer countyId) {
		this.countyId = countyId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
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
