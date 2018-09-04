package com.mipa.osgi.core.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({@NamedQuery(name="provider.by.name.country", 
	query="select obj from ProviderDataEntity where obj.providerName=:providerName and obj.countryId=:countryId")})

@Entity
@Table(name="providerdatamaster")
public class ProviderDataEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="provider_data_table_seq")
	@SequenceGenerator(name="provider_data_table_seq", sequenceName="provider_data_master_seq", initialValue=1)
	@Column(name="providerId", updatable=false, nullable=false)
	private Integer providerId;
	
	@Column(name="providerName")
	private String providerName;
	
	@Column(name="countryId")
	private Short countryId;
	
	@Column(name="pincodes")
	private String pincodes;
	
	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public Short getCountryId() {
		return countryId;
	}

	public void setCountryId(Short countryId) {
		this.countryId = countryId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	
	public String getPincodes() {
		return pincodes;
	}

	public void setPincodes(String pincodes) {
		this.pincodes = pincodes;
	}

}