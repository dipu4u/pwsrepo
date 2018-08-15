package com.mipa.core.data.model;

import java.time.OffsetDateTime;

import com.mipa.core.data.enums.StoreType;

public class StoreDataModel {

	private Integer storeId;
	private String storeName;
	private StoreType storeType;
	private Short countryId;
	private Integer countyId;
	private Integer cityId;
	private String branch;
	private String address;
	private String pincode;
	private String latitude;
	private String longitude;
	private OffsetDateTime createdDate;
	private boolean active;
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