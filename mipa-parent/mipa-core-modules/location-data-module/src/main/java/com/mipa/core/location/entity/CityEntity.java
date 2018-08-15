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
@Table(name = "citymaster")
public class CityEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="city_table_seq")
	@SequenceGenerator(name="city_table_seq", sequenceName="city_master_seq", initialValue=1)
	private Integer cityId;
	
	@Column(name="cityName")
	private String cityName;
	
	@Column(name="countyId")
	private Short countyId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="countyId")
	private CountyEntity county;
	
	@Column(name="countryId")
	private Short countryId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="countryId")
	private CountryEntity country;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Short getCountyId() {
		return countyId;
	}

	public void setCountyId(Short countyId) {
		this.countyId = countyId;
	}

	public CountyEntity getCounty() {
		return county;
	}

	public void setCounty(CountyEntity county) {
		this.county = county;
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