package com.mipa.core.location.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="countrymaster")
public class CountryEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="country_table_seq")
	@SequenceGenerator(name="country_table_seq", sequenceName="country_master_seq", initialValue=1)
	@Column(name="countryId", updatable=false, nullable=false)
	private Short countryId;
	
	@Column(name="countryName", unique=true)
	private String countryName;

	@Column(name="shortCode")
	private String shortCode;

	public Short getCountryId() {
		return countryId;
	}

	public void setCountryId(Short countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}
	
}