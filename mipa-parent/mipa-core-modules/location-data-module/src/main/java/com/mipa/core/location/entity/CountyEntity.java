package com.mipa.core.location.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="countymaster")
public class CountyEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="county_table_seq")
	@SequenceGenerator(name="county_table_seq", sequenceName="county_master_seq", initialValue=1)
	private Integer countyId;
	
	@Column(name="countyName")
	private String countyName;
	
	@Column(name="countryId")
	private Short countryId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="countryId")
	private CountryEntity country;

	public Integer getCountyId() {
		return countyId;
	}

	public void setCountyId(Integer countyId) {
		this.countyId = countyId;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public Short getCountryId() {
		return countryId;
	}

	public void setCountryId(Short countryId) {
		this.countryId = countryId;
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}
	
}